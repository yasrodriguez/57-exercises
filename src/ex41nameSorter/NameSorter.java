package ex41nameSorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Read a list of names from a file, sort them alphabetically and print them to a file with the first line
 * indicating the total number of records.
 * Created by Yasmin on 8/20/2017
 */

public class NameSorter {

    private ArrayList<String> names = new ArrayList<>();

    public void readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        do{
            line = reader.readLine();

            if(line != null){
                names.add(line);
            }
        }while(line != null);

        Collections.sort(names);

        reader.close();
    }

    public void writeToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter (filename));

        writer.write("Total of " + names.size() + " names");
        writer.newLine();
        writer.write("----------------------------");
        writer.newLine();


        for(String name: names){
            writer.write(name);
            writer.newLine();
        }

        writer.close();
    }
}
