package ex51FirebaseNotes;

import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import javax.xml.ws.http.HTTPException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Unit tests and Integration tests for Notes Keeper application.
 */
public class NotesKeeperTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void IntegrationTest_saveNote_validPOSTRequest_ReturnsOK() throws Exception {
        //arrange
        NotesDatabase fb = new FirebaseDatabase();
        NotesKeeper noteApp = new NotesKeeper();
        String note = "Don't cry because it's over, smile because it happened. -Dr. Seuss";

        //act
        String response = noteApp.saveNote(fb, note);

        //assert
        assertTrue(response.contains("Response Code: 200"));
        }

    @Test
    public void IntegrationTest_readNotes_validGETRequest_ReturnsNotes() throws Exception {
        //arrange
        NotesDatabase fb = new FirebaseDatabase();
        NotesKeeper noteApp = new NotesKeeper();

        //act
        String response = noteApp.readNotes(fb);

        //assert
        System.out.println(response);
    }

    @Test
    public void saveNote_NoteInProperJson_IsSavedWithOkResponse() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();
        String note = "Don't cry because it's over, smile because it happened. -Dr. Seuss";
        String noteInJson = noteApp.writeJson(note);

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);
        when(mockedDb.save(noteInJson)).thenReturn("Response Code: 200 \n" +
                "Response: {\"name\":\"-Kw6lHgETApv8J9fPV5m\"}");

        //act
        String response = noteApp.saveNote(mockedDb, note);

        //assert
        assertTrue(response.contains("Response Code: 200"));
    }

    @Test
    public void readNotes_ResponseInProperJson_ParsesCorrectly() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);
        String responseInJson = "{  \"-Kw6lHgETApv8J9fPV5m\" : {    \"date\" : \"2017-10-10\",    \"text\" : \"This is my first note using Firebase\"  },  \"-Kw6mgZjSZiSi1BDK4lW\" : {    \"date\" : \"2017-10-10\",    \"text\" : \"Don't cry because it's over, smile because it happened. -Dr. Seuss\"  },  \"-KwAd3YcKW1Xxdnp9JNI\" : {    \"date\" : \"2017-10-11\",    \"text\" : \"Don't cry because it's over, smile because it happened. -Dr. Seuss\"  }}";
        when(mockedDb.read()).thenReturn(responseInJson);

        String expectedResponse = "2017-10-10 This is my first note using Firebase\n" +
                "2017-10-11 Don't cry because it's over, smile because it happened. -Dr. Seuss\n" +
                "2017-10-10 Don't cry because it's over, smile because it happened. -Dr. Seuss\n";

        //act
        String actualResponse = noteApp.readNotes(mockedDb);

        //assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void saveNote_NullNote_throwsException() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);

        //assert
        exception.expect(IllegalArgumentException.class);

        //act
        String response = noteApp.saveNote(mockedDb, null);
    }

    @Test
    public void saveNote_EmptyNote_throwsException() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);

        //assert
        exception.expect(IllegalArgumentException.class);

        //act
        String response = noteApp.saveNote(mockedDb, "");
    }

    @Test
    public void saveNote_NullDatabase_throwsException() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();
        String note = "Don't cry because it's over, smile because it happened. -Dr. Seuss";
        String noteInJson = noteApp.writeJson(note);

        //assert
        exception.expect(IllegalArgumentException.class);

        //act
        String response = noteApp.saveNote(null, noteInJson);
    }

    @Test
    public void readNotes_MalformedJsonResponse_throwsException() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);
        //Response is missing the first brace
        String responseInJson = "\"-Kw6lHgETApv8J9fPV5m\" : {    \"date\" : \"2017-10-10\",    \"text\" : \"This is my first note using Firebase\"  }}";
        when(mockedDb.read()).thenReturn(responseInJson);

        //assert
        exception.expect(ParseException.class);

        //act
        String actualResponse = noteApp.readNotes(mockedDb);
    }

    @Test
    public void saveNote_HttpException_throwsException() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();
        String note = "Don't cry because it's over, smile because it happened. -Dr. Seuss";
        String noteInJson = noteApp.writeJson(note);

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);
        when(mockedDb.save(noteInJson)).thenThrow(HTTPException.class);

        //assert
        exception.expect(HTTPException.class);

        //act
        String response = noteApp.saveNote(mockedDb, note);
    }

    @Test
    public void readNotes_HttpException_throwsException() throws Exception {
        //arrange
        NotesKeeper noteApp = new NotesKeeper();

        NotesDatabase mockedDb = Mockito.mock(NotesDatabase.class);
        when(mockedDb.read()).thenThrow(HTTPException.class);

        //assert
        exception.expect(HTTPException.class);

        //act
        String actualResponse = noteApp.readNotes(mockedDb);
    }
}
