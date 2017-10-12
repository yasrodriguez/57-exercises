package ex52CurrentTime;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Returns the current server time.
 * @author Yasmin
 *
 */

@Path("/currenttime")
public class CurrentTime {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTime() {
		String dateTime = "{\"current_date\":\"" + LocalDate.now() + "\"" + ",\"current_time\":\"" + LocalTime.now()
				+ "\"}";
		return dateTime;
	}
}
