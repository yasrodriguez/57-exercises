package ex32GuessTheNumber;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Unit tests for Guess the Number game.
 * Created by Yasmin on 8/7/17
 */
public class GuessTheNumberTest {

    @Test
    public void check_random_number_for_level_1() throws Exception{
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Beginner);
        int randomNum = gtn.getRandomNumber();
        assertTrue(randomNum >= 0 && randomNum <= 10);
    }

    @Test
    public void check_random_number_for_level_2() throws Exception{
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Intermediate);
        int randomNum = gtn.getRandomNumber();
        assertTrue(randomNum >= 0 && randomNum <= 100);
    }

    @Test
    public void check_random_number_for_level_3() throws Exception{
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Advanced);
        int randomNum = gtn.getRandomNumber();
        assertTrue(randomNum >= 0 && randomNum <= 1000);
    }
    @Test
    public void level_1_guess_low() throws Exception{
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Beginner, 15);  //Using this seed the random number is 2
        assertEquals("Too Low", gtn.play(1));
        }

    @Test
    public void level_1_guess_high() throws Exception {
            GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Beginner, 15);  //Using this seed the random number is 2
            assertEquals("Too High", gtn.play(3));
        }

    @Test
    public void level_1_guess_right() throws Exception {
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Beginner, 15);  //Using this seed the random number is 2
        assertEquals("Equal", gtn.play(2));
    }

    @Test
    public void level_2_guess_low() throws Exception{
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Intermediate, 25);  //Using this seed the random number is 82
        assertEquals("Too Low", gtn.play(81));
    }

    @Test
    public void level_2_guess_high() throws Exception {
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Intermediate, 25);  //Using this seed the random number is 82
        assertEquals("Too High", gtn.play(83));
    }

    @Test
    public void level_2_guess_right() throws Exception {
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Intermediate, 25);  //Using this seed the random number is 82
        assertEquals("Equal", gtn.play(82));
    }

    @Test
    public void level_3_guess_low() throws Exception{
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Advanced, 5);  //Using this seed the random number is 488
        assertEquals("Too Low", gtn.play(300));
    }

    @Test
    public void level_3_guess_high() throws Exception {
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Advanced, 5);  //Using this seed the random number is 488
        assertEquals("Too High", gtn.play(489));
    }

    @Test
    public void level_3_guess_right() throws Exception {
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Advanced, 5);  //Using this seed the random number is 488
        assertEquals("Equal", gtn.play(488));
    }

    @Test
    public void guess_multiple_times() throws Exception {
        GuessTheNumber gtn = new GuessTheNumber(GuessTheNumber.Level.Advanced, 15);  //Using this seed the random number is 2
        gtn.play(10);
        gtn.play(7);
        gtn.play(4);
        gtn.play(3);
        assertEquals(4, gtn.getNumberOfGuesses());
    }
}