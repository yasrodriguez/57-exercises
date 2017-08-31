package ex46wordCounter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Word Counter.
 */
public class WordCounterTest {
    //TODO: Complete

    @Test
    public void test()throws Exception{
        WordCounter wc = new WordCounter();
        wc.count("src/ex46wordCounter/annabel-lee.txt");
        wc.generateHistogram();
    }

}