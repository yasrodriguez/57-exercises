package ex27inputValidator;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import static org.junit.Assert.*;

/**
 * Unit tests for Input Validator.
 * Created by Yasmin Rodriguez on 8/4/17.
 */
public class InputValidatorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void valid_first_and_last_name()throws Exception{
        InputValidator.validateInput("Brad", "Pitt",  "ABC-1234", "48199");
    }

    @Test
    public void blank_first_name()throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("First name nor last name can't be blank.");
        InputValidator.validateInput("","Pitt", "ABC-1234", "48199");
    }

    @Test
    public void blank_last_name()throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("First name nor last name can't be blank.");
        InputValidator.validateInput("Brad","", "ABC-1234", "48199");
    }

    @Test
    public void null_first_name() throws Exception{
        try {
            InputValidator.validateInput(null, "Pitt", "ABC-1234", "48199");
        }
        catch(Exception e){
            assertEquals("java.lang.NullPointerException", e.getMessage());
        }
    }

    @Test
    public void null_last_name() throws Exception{
        try {
            InputValidator.validateInput("Brad", null, "ABC-1234", "48199");
        }
        catch(Exception e){
            assertEquals("java.lang.NullPointerException", e.getMessage());
        }
    }

}