package ex47peopleInSpace;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests for People In Space program.
 * Created by Yasmin on 9/6/2017
 */

public class PeopleInSpaceTest {

    @Test
    public void integration_test_that_calls_and_reads_the_json_from_the_api() throws Exception{
        PeopleInSpace p = new PeopleInSpace();
        JsonGetter jsonGetter = new JsonGetter();
        p.read(jsonGetter);
        System.out.println(p.generateReport());
    }

    @Test
    public void unit_test_that_parses_a_json_string() throws Exception{
        //arrange
        PeopleInSpace p = new PeopleInSpace();
        JsonGetterMock mock = new JsonGetterMock();
        String expectedResult = "There are 3 people in space right now: \n" +
                "\n" +
                "Name                           Craft          \n" +
                "---------------------------|--------------\n" +
                "Sergey Ryazanskiy              ISS            \n" +
                "Randy Bresnik                  ISS            \n" +
                "Paolo Nespoli                  ISS            \n";

        //act
        p.read(mock);

        //assert
        assertEquals(expectedResult, p.generateReport());
    }
}
