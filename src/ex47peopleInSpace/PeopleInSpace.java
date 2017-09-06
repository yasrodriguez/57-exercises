package ex47peopleInSpace;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Use the Open Notify API http://api.open-notify.org/astros.json to obtain a list of people currently in space and
 * display the information in tabular format. *
 * Constraints:
 * Read the data directly from the API and parse the results each time the program is run.
 * Created by Yasmin on 9/6/2017
 */

public class PeopleInSpace {

    ArrayList<Person> peopleInSpace = new ArrayList<>();

     private class Person{

        String name;
        String craft;

        public Person(String name, String craft){
            this.name = name;
            this.craft = craft;
        }

         public String getName() {
             return name;
         }

         public String getCraft() {
             return craft;
         }
     }

    public void read() throws IOException, ParseException{
        JSONParser parser = new JSONParser();

        URL openNotifyApi = new URL("http://api.open-notify.org/astros.json");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(openNotifyApi.openStream()))) {
            JSONObject json = (JSONObject) parser.parse(reader);

            JSONArray people = (JSONArray) json.get("people");
            Iterator i = people.iterator();

            while (i.hasNext()) {
                JSONObject person = (JSONObject) i.next();
                String name = (String) person.get("name");
                String craft = (String) person.get("craft");
                peopleInSpace.add(new Person(name, craft));
            }
        }
    }

    public String generateReport(){
        StringBuilder sb = new StringBuilder();

        sb.append("There are " + peopleInSpace.size() + " people in space right now: \n\n");
        sb.append(String.format("%-30s %-15s\n", "Name", "Craft"));
        sb.append("---------------------------|--------------\n");

        for(Person p: peopleInSpace){
            sb.append(String.format("%-30s %-15s\n", p.getName(), p.getCraft()));
        }

        return sb.toString();
    }
}


