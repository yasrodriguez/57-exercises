package ex46wordCounter;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Read a file and count the frequency of each word. Construct a histogram with the words and their frequencies, sorted
 * with the most frequent words at the top.
 * Poem obtained here: https://www.poetryfoundation.org/poems/44885/annabel-lee
 * Created by Yasmin on 8/30/2017
 */

public class WordCounter {
    private TreeMap<String, Integer> wordCount = new TreeMap<>();

    public void count(String filename)throws IOException{
        File file = new File(filename);
        if(file.length() == 0){
            throw new IllegalArgumentException("File is empty.");
        }

        Scanner s = new Scanner(new BufferedReader(new FileReader(file)));

        //TODO: Complete
            while (s.hasNext()) {
                String word = s.next();
                if (!wordCount.containsValue(word)){
                    wordCount.put(word, 1);
                }
            }
        }
    }
