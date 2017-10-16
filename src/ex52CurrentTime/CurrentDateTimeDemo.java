package ex52CurrentTime;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Client for the CurrentDateTime web service.
 * 
 * @author Yasmin
 *
 */
public class CurrentDateTimeDemo {

	public static String getDateTime(CurrentDateTimeGetter dt) throws IOException {
		if (dt == null) {
			throw new IllegalArgumentException();
		}
		String json = dt.getDateTime();
		return parseDateTime(json);
	}

	private static String parseDateTime(String json) throws IOException {
		ObjectMapper objMapper = new ObjectMapper();
		
		JsonNode rootNode = objMapper.readTree(json);
		JsonNode date = rootNode.path("current_date");
		JsonNode time = rootNode.path("current_time");
		
		return "The current time is " + date.asText() + " " + time.asText();
	}
}
