package ex33magic8Ball;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Magic 8 Ball
 * Created by Yasmin on 8/9/17
 */

public class Magic8BallTest {

    @Test
    public void test_that_response_returned_is_on_the_list(){
        String response = Magic8Ball.turnTheBall();
        System.out.println(response);
        assertTrue(response,response.equals("Yes") || response.equals("No") || response.equals("Maybe")
                || response.equals("Ask again later"));
    }
}