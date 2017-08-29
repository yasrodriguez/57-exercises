package ex45wordFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Read a given input file, look for all the occurrences of a given word and replace with the word provided.  Write the
 * modified file to a new file.
 * Created by Yasmin on 8/29/2017
 */

public class WordFinder {
    private String originalFile = "";
    private String newFile = "";

    public void readFile(String filename) throws IOException {
        Path file = Paths.get(filename);
        originalFile = new String(Files.readAllBytes(file));
        if (originalFile.isEmpty()){
            throw new IllegalArgumentException("File is empty.");
        }
    }

    public void replace(String oldWord, String newWord){
        newFile = originalFile.replace(oldWord, newWord);
    }

    public String writeFile() throws IOException{
        Path newFilePath = Paths.get("src/ex45wordFinder/new-text.txt");
        Files.write(newFilePath, newFile.getBytes());
        return newFile;
    }
}
