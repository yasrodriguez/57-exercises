package ex46wordCounter;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map.Entry;


/**
 * Read a file and count the frequency of each word. Print a histogram with the words and their frequencies, sorted
 * by descending frequency.
 * Poem obtained here: https://www.poetryfoundation.org/poems/44885/annabel-lee
 * Created by Yasmin on 8/30/2017
 */

public class WordCounter {
    private TreeMap<String, Integer> wordInventory = new TreeMap<>();

    public void count(String filename)throws IOException {
        File file = new File(filename);
        if (file.length() == 0) {
            throw new IllegalArgumentException("File is empty.");
        }

        try (Scanner s = new Scanner(new BufferedReader(new FileReader(file)))) {

           //TODO: Ignore special characters and punctuation

            while (s.hasNext()) {
                String word = s.next();

                if (!wordInventory.containsKey(word)) {
                    wordInventory.put(word, 1);
                } else {
                    int previousCount = wordInventory.get(word);
                    wordInventory.put(word, previousCount + 1);
                }
            }
        }
    }

    public String generateHistogram(){
        ArrayList<Entry<String,Integer>> sortedWordInventory = sortByDescendingFrequency();

        //TODO: Print the words and their counts using *
        return "";
    }

    private ArrayList<Entry<String, Integer>> sortByDescendingFrequency(){
        ArrayList<Entry<String,Integer>> words = new ArrayList<>();
        words.addAll(wordInventory.entrySet());
        words.sort(new DescendingValueComparator());
        System.out.println(words);
        return words;
    }

    class DescendingValueComparator implements Comparator<Entry<String,Integer>>{
        public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
            return e2.getValue().compareTo(e1.getValue());
        }
    }
}
