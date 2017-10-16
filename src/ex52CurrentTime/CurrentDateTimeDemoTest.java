package ex52CurrentTime;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.JsonParseException;

/**
 * Integration and unit tests for CurrentDateTimeDemo.
 * 
 * @author Yasmin
 *
 */
public class CurrentDateTimeDemoTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void IntegrationTest_getDateTime_returnsCurrentDateAndTime() throws Exception {
		MyCurrentDateTimeGetter myDateTimeGetter = new MyCurrentDateTimeGetter();

		String result = CurrentDateTimeDemo.getDateTime(myDateTimeGetter);

		System.out.println(result);
	}

	@Test
	public void getDateTime_validResponse_returnsDateAndTime() throws Exception {
		CurrentDateTimeGetter dt = Mockito.mock(CurrentDateTimeGetter.class);
		Mockito.when(dt.getDateTime())
				.thenReturn("{\"current_date\":\"2017-10-14\",\"current_time\":\"08:27:24.481\"}");
		String expectedResult = "The current time is 2017-10-14 08:27:24.481";

		String actualResult = CurrentDateTimeDemo.getDateTime(dt);

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void getDateTime_nullInterface_throwsException() throws Exception {
		exception.expect(IllegalArgumentException.class);

		CurrentDateTimeDemo.getDateTime(null);
	}

	@Test
	public void getDateTime_malformedJson_throwsException() throws Exception {

		CurrentDateTimeGetter dt = Mockito.mock(CurrentDateTimeGetter.class);

		// Json has an extra set of brackets to make it invalid
		Mockito.when(dt.getDateTime())
				.thenReturn("{{\"current_date\":\"2017-10-14\",\"current_time\":\"08:27:24.481\"}}");

		exception.expect(JsonParseException.class);

		String actualResult = CurrentDateTimeDemo.getDateTime(dt);
	}
}
