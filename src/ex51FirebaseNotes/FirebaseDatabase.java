package ex51FirebaseNotes;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.http.HTTPException;
import java.io.*;
import java.net.URL;
import java.util.Arrays;

/**
 * Authenticates user's access to Google's Firebase database service. Saves to and reads from the Firebase database.
 */
public class FirebaseDatabase implements NotesDatabase {
    private String accessToken;

    /**
     * Constructor for the FirebaseDatabase. Reads the service key from the path specified and generates Google OAuth2
     * access token.
     * @throws IOException If there's an I/O error when reading the file that contains the service key.
     */
    public FirebaseDatabase() throws IOException {
        //Change the path so that it points to the file that contains your Firebase service key.
        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\Yasmin\\Documents\\api_keys\\FirebaseServiceKey.json");

        // Authenticate a Google credential with the service account
        GoogleCredential googleCred = GoogleCredential.fromStream(serviceAccount);

        // Add the required scopes to the Google credential
        GoogleCredential scoped = googleCred.createScoped(
                Arrays.asList(
                        "https://www.googleapis.com/auth/firebase.database",
                        "https://www.googleapis.com/auth/userinfo.email"
                )
        );

        // Use the Google credential to generate an access token
        scoped.refreshToken();
        accessToken = scoped.getAccessToken();
    }

    /**
     * Saves JSON string to the database.
     * @param json information to save, in JSON format
     * @return  response from the Firebase database service
     * @throws IOException If there's an I/O error when connecting to the Firebase database
     */
    @Override
    public String save(String json) throws IOException {
        final String POST_URL = String.format("https://my-notes-keeper.firebaseio.com/notes.json?access_token=%s",
               accessToken);
        URL url = new URL(POST_URL);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            os.write(json.getBytes());
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();


            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            return String.format("Response Code: %s \nResponse: %s\n", responseCode, response);
        } else {
            throw new HTTPException(responseCode);
        }
    }

    /**
     * Reads all the contents of the Firebase database found under Notes.
     * @return notes in JSON format
     * @throws IOException If there's an I/O error when connecting to the Firebase database
     */
    @Override
    public String read() throws IOException {
        final String GET_URL = String.format("https://my-notes-keeper.firebaseio.com/notes.json?print=pretty&access_token=%s",
                accessToken);
        URL url = new URL(GET_URL);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            return response.toString();
        } else {
            throw new HTTPException(responseCode);
        }
    }
}