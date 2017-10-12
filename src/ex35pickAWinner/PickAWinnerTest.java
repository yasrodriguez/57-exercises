package ex35pickAWinner;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Pick a Winner
 * Created by Yasmin on 8/10/17
 */
public class PickAWinnerTest {

    @Test
    public void pick_a_winner_from_two()throws Exception{
        PickAWinner paw = new PickAWinner();
        paw.addContestant("Snoopy");
        paw.addContestant("Clifford");
        String winner = paw.selectWinner();
        System.out.println("The winner is " + winner);
        assertTrue(!winner.isEmpty());
    }

    @Test
    public void pick_a_winner_from_one() throws Exception{
        PickAWinner paw = new PickAWinner();
        paw.addContestant("Grumpy Cat");
        assertEquals("Of course you know the winner can only be Grumpy Cat", paw.selectWinner());
    }

    @Test
    public void try_to_pick_a_winner_when_there_are_no_contestants() throws Exception{
        PickAWinner paw = new PickAWinner();
        assertEquals("Sorry you haven\'t entered any contestants", paw.selectWinner());
    }

    @Test
    public void try_to_pick_a_winner_after_entering_an_empty_contestant() throws Exception{
        PickAWinner paw = new PickAWinner();
        paw.addContestant("");
        assertEquals("Sorry you haven\'t entered any contestants", paw.selectWinner());
    }
}