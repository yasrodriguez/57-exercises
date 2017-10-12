package ex51FirebaseNotes;

import java.io.IOException;

/**
 * Interface for the data layer.
 */
public interface NotesDatabase {

    String save(String note) throws IOException;

    String read() throws IOException;
}
