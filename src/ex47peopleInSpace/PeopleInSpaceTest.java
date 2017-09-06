package ex47peopleInSpace;

import org.junit.Test;

/**
 * Manual tests for People In Space program.
 * Created by Yasmin on 9/6/2017
 */

public class PeopleInSpaceTest {

    @Test
    public void manual_test_to_verify_that_it_prints_a_list_of_names_and_crafts() throws Exception{
        PeopleInSpace p = new PeopleInSpace();
        p.read();
        System.out.println(p.generateReport());
    }
}
