package ex52CurrentTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Returns date and time from the web service server.
 * 
 * @author Yasmin
 *
 */
public class MyCurrentDateTimeGetter implements CurrentDateTimeGetter {

	public String getDateTime() throws IOException {
		URL url = new URL("http://localhost:8080/57-exercises-web/rest/currenttime");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
			return reader.readLine();
		}
	}

}
