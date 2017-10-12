package ex52CurrentTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrentTimeServicesClient {

	public static void main(String[] args) throws IOException {
		CurrentTimeServicesClient time = new CurrentTimeServicesClient();
		String json = time.getTime();
		String response = time.parseTime(json);
		System.out.println(response);
	}

	public String getTime() throws IOException {
		URL url = new URL("http://localhost:8080/57-exercises-web/rest/currenttime");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
			return reader.readLine();
		}
	}

	public String parseTime(String json) throws IOException {
		ObjectMapper objMapper = new ObjectMapper();
		
		JsonNode rootNode = objMapper.readTree(json);
		JsonNode date = rootNode.path("current_date");
		JsonNode time = rootNode.path("current_time");
		return "The current time is " + date + " " + time;
	}

}
