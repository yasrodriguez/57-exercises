package ex44productReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


/**
 * Take in a product name and retrieve its details from a file in JSON format. Print the product name,
  * price, and quantity. If there are no matches, print a message that the product was not found and start again.
  * Constraints:
  * File is in JSON format. Use a JSON parser to pull the values out of the file.  I decided to use
  * JSON-Simple: https://code.google.com/archive/p/json-simple/
 * Created by Yasmin on 8/27/2017
 */

public class ProductReader {

 public static void readFile(String filename) throws IOException, ParseException{
    JSONParser parser = new JSONParser();
    FileReader fileReader = new FileReader(filename);
    JSONObject json = (JSONObject)parser.parse(fileReader);

   JSONArray products = (JSONArray)  json.get("products");
   Iterator i = products.iterator();
   while(i.hasNext()){

       JSONObject product = (JSONObject) i.next();

     String name = (String) product.get("name");
     double price = (double) product.get("price");
     long quantity = (long) product.get("quantity");
     System.out.println(name + " " +  price + " " +  quantity);
   }
 }

 public static void main(String[] args) throws IOException, ParseException{
  ProductReader.readFile("src/ex44productReader/products.json");
 }
}
