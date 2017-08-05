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
    @Test
    public void valid_first_and_last_name()throws Exception{
        InputValidator iv = new InputValidator("Brad", "Pitt",  "ABC-1234",
                "48199");
        assertEquals("", iv.validateInput());

    }

    @Test
    public void blank_first_name()throws Exception{
        InputValidator iv = new InputValidator("", "Pitt",  "ABC-1234",
                "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void null_first_name() throws Exception{
        InputValidator iv = new InputValidator(null, "Pitt", "ABC-1234", "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void blank_last_name()throws Exception{
        InputValidator iv = new InputValidator("Brad","", "ABC-1234", "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void null_last_name() throws Exception{
        InputValidator iv = new InputValidator("Brad", null, "ABC-1234", "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void first_name_is_less_than_2_characters () throws Exception{
        InputValidator iv = new InputValidator("B", "Pitt", "ABC-1234", "48199");
        assertEquals("First name nor last name can't be shorter than 2 characters.\n", iv.validateInput());
    }

    @Test
    public void first_name_is_2_characters () throws Exception{
        InputValidator iv = new InputValidator("Bo", "Schembechler", "ABC-1234", "48199");
        assertEquals("", iv.validateInput());
    }

    @Test
    public void last_name_is_less_than_2_characters () throws Exception{
        InputValidator iv = new InputValidator("Brad", "P", "ABC-1234", "48199");
        assertEquals("First name nor last name can't be shorter than 2 characters.\n", iv.validateInput());
    }

}