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

    public TreeSet<Word> getWordInventory() {
        return wordInventory;
    }

    public void count(String filename) throws IOException {
        File file = new File(filename);
        if (file.length() == 0) {
            throw new IllegalArgumentException("File is empty.");
        }

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (s.hasNext()) {
                String input = s.next();
                Word word = new Word(input, 0);

                if (!wordInventory.contains(word)) {
                    word.setCount(1);
                    wordInventory.add(word);
                } else {
                    int currentCount = wordInventory.floor(word).getCount();
                    wordInventory.floor(word).setCount(currentCount + 1);
                }
            }
        }
    }

        public String generateHistogram(){
       TreeSet<Word> sortedWordInventory = new TreeSet<>(new DescendingCount());
       sortedWordInventory.addAll(wordInventory);

       StringBuilder report = new StringBuilder();
            for(Word w: sortedWordInventory){
                report.append(String.format("%-12s: ", w.getName()));

                int count = w.getCount();
                for(int i = 1; i <= count; i++){
                    report.append("*");
                }

                report.append("\n");
            }
            return report.toString();
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
