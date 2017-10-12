package ex25passwordValidator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

/** Unit tests for Password Validator
 * Created by Yasmin Rodriguez on 8/1/17.
 */

public class PasswordValidatorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void very_weak_password() throws Exception {
        PasswordValidator pv = new PasswordValidator("12345");
        assertEquals(PasswordValidator.PasswordStrength.VeryWeak, pv.validatePassword());
    }

    @Test
    public void weak_password() throws Exception {
        PasswordValidator pv = new PasswordValidator("Paris");
        assertEquals(PasswordValidator.PasswordStrength.Weak, pv.validatePassword());
    }

    @Test
    public void medium_password() throws Exception {
        PasswordValidator pv = new PasswordValidator("Michigan");
        assertEquals(PasswordValidator.PasswordStrength.Medium, pv.validatePassword());
    }

    @Test
    public void strong_password() throws Exception {
        PasswordValidator pv = new PasswordValidator("Michigan1");
        assertEquals(PasswordValidator.PasswordStrength.Strong, pv.validatePassword());
    }

    @Test
    public void very_strong_password() throws Exception {
        PasswordValidator pv = new PasswordValidator("Michigan1$");
        assertEquals(PasswordValidator.PasswordStrength.VeryStrong, pv.validatePassword());
    }

    @Test
    public void blank_password() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You can't have a blank password");
        PasswordValidator pv = new PasswordValidator("");
        assertEquals(PasswordValidator.PasswordStrength.VeryWeak, pv.validatePassword());
    }

    @Test
    public void null_password() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You can't have a blank password");
        PasswordValidator pv = new PasswordValidator(null);
        assertEquals(PasswordValidator.PasswordStrength.VeryWeak, pv.validatePassword());
    }

}