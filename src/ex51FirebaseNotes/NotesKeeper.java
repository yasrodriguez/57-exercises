package ex51FirebaseNotes;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * This program allows the user to save notes and display saved notes. It uses Google's Firebase database service:
 * https://firebase.google.com/docs/database/rest/start
 *
 * Created by Yasmin on 10/9/2017
 */

public class NotesKeeper {

    /**
     * Saves the note to the Firebase database specified.
     * @param d the Firebase database
     * @param note the note
     * @return response from the Firebase database service
     * @throws IOException If there's an I/O error when connecting to the Firebase database
     */
    public String saveNote(NotesDatabase d, String note) throws IOException {
        if (d == null) {
            throw new IllegalArgumentException("Database can't be null.");
        }

        if (note == null || note.isEmpty()) {
            throw new IllegalArgumentException("Note can't be null or empty.");
        }

        String json = writeJson(note);
        return d.save(json);
    }

    /**
     * Reads all the notes from the specified Firebase database.
     * @param d the Firebase database
     * @return notes in a nice format
     * @throws IOException If there's an I/O error when connecting to the Firebase database
     * @throws ParseException If the response contains malformed JSON
     */
    public String readNotes(NotesDatabase d) throws IOException, ParseException {
        String json = d.read();
        return parseJson(json);
    }

    /**
     * Converts the note to JSON format.
     * @param note the note
     * @return note in JSON format
     */
    String writeJson(String note) {
        JSONObject obj = new JSONObject();

        obj.put("text", note);
        obj.put("date", LocalDate.now().toString());

        return obj.toString();
    }

    /**
     * Parses JSON received into notes in a nice human readable format.
     * @param response  JSON response from the Firebase database service
     * @return notes in human readable format
     * @throws ParseException If the response contains malformed JSON
     */
     String parseJson(String response) throws ParseException{
        StringBuilder notes = new StringBuilder();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);

        Iterator i = json.entrySet().iterator();

        while(i.hasNext()) {
            Map.Entry record = (Map.Entry) i.next();
            JSONObject obj = (JSONObject) record.getValue();
            String date = (String) obj.get("date");
            String text = (String)  obj.get("text");
            String note = String.format("%s %s\n", date, text);
            notes.append(note);
        }
        return notes.toString();
    }
}



