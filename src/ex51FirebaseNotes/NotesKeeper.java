package ex51FirebaseNotes;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

/**
 * The program uses the Firebase service to allow the user to enter and save a note as well as display saved notes.
 * https://firebase.google.com/docs/database/rest/start
 * Constraints:
 * Create a configuration file to store the API key.
 * Use the REST documentation instead of a premade client library.
 * Created by Yasmin on 10/9/2017
 */

public class NotesKeeper {

    String accessToken;

    public NotesKeeper() throws IOException {
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

    public String saveNote(String note) throws IOException {
        final String POST_URL = String.format("https://my-notes-keeper.firebaseio.com/notes.json?access_token=%s",
              accessToken);
        URL url = new URL(POST_URL);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        String POST_PARAMS = writeJson(note);

        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            os.write(POST_PARAMS.getBytes());
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
        }
        else {
            return String.format("POST Request Failed. Response Code: %s \n", responseCode);
        }
    }

    public String writeJson(String note) {
        JSONObject obj = new JSONObject();

        obj.put("text", note);
        obj.put("date", LocalDate.now().toString());

        return obj.toString();
    }

    public String readNotes() throws IOException, ParseException {
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
            String formattedResponse = parseJson(response.toString());
            return formattedResponse;
        }
        else {
            return String.format("POST Request Failed. Response Code: %s \n", responseCode);
        }
    }

    public String parseJson(String response) throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);

        Iterator i = json.entrySet().iterator();

        while(i.hasNext()) {
            Map.Entry record = (Map.Entry) i.next();
            JSONObject obj = (JSONObject) record.getValue();
            String date = (String) obj.get("date");
            String note = (String)  obj.get("text");
           System.out.println(date + " " + note);
        }
        return "";
    }
}



