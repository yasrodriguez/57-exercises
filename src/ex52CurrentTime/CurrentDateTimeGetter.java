package ex52CurrentTime;

import java.io.IOException;

/**
 * Interface for current date and time getter.
 * 
 * @author Yasmin
 *
 */
public interface CurrentDateTimeGetter {
	
	String getDateTime() throws IOException;
	
}
