package ex51FirebaseNotes;

import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

/**
 * Unit tests for Notes Keeper application.
 */
public class NotesKeeperTest {

    @Test
    public void saveNote_validPOSTRequest_ReturnsOK() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();
        String note = "Don't cry because it's over, smile because it happened. -Dr. Seuss";

        //act
        String response = noteApp.saveNote(note);

        //assert
        assertTrue(response.contains("Response Code: 200"));
        }

    @Test
    public void readNotes_validGETRequest_ReturnsNotes() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();

        //act
        String response = noteApp.readNotes();

        //assert
        System.out.println(response);
    }
}