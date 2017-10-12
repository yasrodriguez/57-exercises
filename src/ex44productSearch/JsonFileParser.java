package ex44productSearch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;


/**
 *  Take in a product name to search for and retrieve its details from the specified JSON file. Print the product name,
  * price, and quantity. If there are no matches, print a message that the product was not found and start again.
  * Constraints:
  * File is in JSON format. Use a JSON parser to pull the values out of the file.
 * I decided to use JSON-Simple: https://code.google.com/archive/p/json-simple/
 * Created by Yasmin on 8/27/2017
 */

public class JsonFileParser {

 public static HashMap<String, Product> readFile(String filename) throws IOException, ParseException{
    JSONParser parser = new JSONParser();
    FileReader fileReader = new FileReader(filename);
    JSONObject json = (JSONObject)parser.parse(fileReader);

    JSONArray jsonArray = (JSONArray)  json.get("products");
    Iterator iterator = jsonArray.iterator();
    HashMap<String, Product> productList = new HashMap<>();

    while(iterator.hasNext()){
        JSONObject productObject = (JSONObject) iterator.next();
        String name = (String) productObject.get("name");
        double price = Math.round((double) productObject.get("price"));
        long quantity = (long) productObject.get("quantity");
        Product product = new Product(name, price, quantity);
        productList.put(name, product);
   }
     return productList;
 }
}
