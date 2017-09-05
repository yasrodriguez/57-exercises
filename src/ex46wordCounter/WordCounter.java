package ex46wordCounter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


/**
 * Read a file and count the frequency of each word. Print a histogram with the words and their frequencies, sorted
 * by descending frequency.
 * Poem obtained here: https://www.poetryfoundation.org/poems/44885/annabel-lee
 * Created by Yasmin on 8/30/2017
 */

public class WordCounter {
    private TreeSet<Word> wordInventory = new TreeSet<>();

    public void count(String filename) throws IOException {
        File file = new File(filename);
        if (file.length() == 0) {
            throw new IllegalArgumentException("File is empty.");
        }

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(file)))) {

            //TODO: Ignore special characters and punctuation

            while (s.hasNext()) {
                String input = s.next();
                //System.out.println(input);  //Test
                Word word = new Word(input, 0);

                if (!wordInventory.contains(word)) {
                    word.setCount(1);
                    wordInventory.add(word);
                    //System.out.println(word);  //Test
                    //System.out.println(wordInventory);  //Test
                } else {
                    int currentCount = wordInventory.floor(word).getCount();
                    wordInventory.floor(word).setCount(currentCount + 1);
                }
            }
        }
        //System.out.println(wordInventory);  //Test
    }

        public String generateHistogram(){
       TreeSet<Word> sortedWordInventory = new TreeSet<>(new DescendingCount());
       sortedWordInventory.addAll(wordInventory);
       //System.out.println(sortedWordInventory);

            for(Word w: sortedWordInventory){
                System.out.printf("%-15s ", w.getName());
                int count = w.getCount();
                for(int i = 1; i <= count; i++){
                    System.out.print("*");
                }
                System.out.println();
            }

        //TODO: Print the words and their counts using *
        return "";
    }

    class DescendingCount implements Comparator<Word> {

        @Override
        public int compare(Word e1, Word e2) {
            int countComparison =  e2.getCount() - e1.getCount();
            if(countComparison != 0){
                return countComparison;
            }
            return e1.getName().compareTo(e2.getName());
        }
    }
}
