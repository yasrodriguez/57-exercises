package ex27inputValidator;

import jdk.internal.util.xml.impl.Input;
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
        InputValidator iv = new InputValidator("Brad", "Pitt",  "AB-1234",
                "48199");
        assertEquals("", iv.validateInput());

    }

    @Test
    public void blank_first_name()throws Exception{
        InputValidator iv = new InputValidator("", "Pitt",  "AB-1234",
                "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void null_first_name() throws Exception{
        InputValidator iv = new InputValidator(null, "Pitt", "AB-1234", "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void blank_last_name()throws Exception{
        InputValidator iv = new InputValidator("Brad","", "AB-1234", "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void null_last_name() throws Exception{
        InputValidator iv = new InputValidator("Brad", null, "AB-1234", "48199");
        assertEquals("Blank or null values are not allowed.\n", iv.validateInput());
    }

    @Test
    public void first_name_is_less_than_2_characters () throws Exception{
        InputValidator iv = new InputValidator("B", "Pitt", "AB-1234", "48199");
        assertEquals("First name nor last name can't be shorter than 2 characters.\n", iv.validateInput());
    }

    @Test
    public void first_name_is_2_characters () throws Exception{
        InputValidator iv = new InputValidator("Bo", "Schembechler", "AB-1234", "48199");
        assertEquals("", iv.validateInput());
    }

    @Test
    public void last_name_is_less_than_2_characters () throws Exception{
        InputValidator iv = new InputValidator("Brad", "P", "AB-1234", "48199");
        assertEquals("First name nor last name can't be shorter than 2 characters.\n", iv.validateInput());
    }

    @Test
    public void zip_code_starts_with_a_letter() throws Exception{
        InputValidator iv = new InputValidator("Brad","Pitt","AB-1234", "a123");
        assertEquals("Zip code must be a number.\n", iv.validateInput());
    }

    @Test
    public void zip_code_ends_with_a_letter() throws Exception{
        InputValidator iv = new InputValidator("Brad","Pitt","AB-1234", "0098a");
        assertEquals("Zip code must be a number.\n", iv.validateInput());
    }

    @Test
    public void zip_code_contains_a_letter() throws Exception{
        InputValidator iv = new InputValidator("Brad","Pitt","AB-1234", "00a85");
        assertEquals("Zip code must be a number.\n", iv.validateInput());
    }

    @Test
    public void employee_Id_has_no_dash() throws Exception{
        InputValidator iv = new InputValidator("Brad","Pitt","AB1234", "00985");
        assertEquals("Employee ID must be have 2 letters and 4 numbers like AB-1234.\n", iv.validateInput());
    }

    @Test
    public void employee_Id_has_3_letters() throws Exception{
        InputValidator iv = new InputValidator("Brad","Pitt","ABC-1234", "00985");
        assertEquals("Employee ID must be have 2 letters and 4 numbers like AB-1234.\n", iv.validateInput());
    }

    @Test
    public void employee_Id_has_3_numbers() throws Exception{
        InputValidator iv = new InputValidator("Brad","Pitt","AB-123", "00985");
        assertEquals("Employee ID must be have 2 letters and 4 numbers like AB-1234.\n", iv.validateInput());
    }

    @Test
    public void fist_name_is_less_than_2_characters_and_employee_id__has_3_letters() throws Exception{
        InputValidator iv = new InputValidator("B","Pitt","ABC-1234", "00985");
        assertEquals("First name nor last name can't be shorter than 2 characters.\nEmployee ID must " +
                "be have 2 letters and 4 numbers like AB-1234.\n", iv.validateInput());
    }

    @Test
    public void all_conditions_are_triggered() throws Exception{
        InputValidator iv = new InputValidator(null,"P","123", "*a123");
        assertEquals("Blank or null values are not allowed.\nFirst name nor last name can't be shorter " +
                "than 2 characters.\nEmployee ID must be have 2 letters and 4 numbers like AB-1234.\nZip code" +
                " must be a number.\n", iv.validateInput());
    }
}