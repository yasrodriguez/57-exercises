package ex44productSearch;

import java.util.HashMap;

/**
 * Product Inventory takes in a product name and returns product information.
 * Created by Yasmin on 8/28/2017
 */

public class ProductInventory{
    private HashMap<String, Product> products;

    public ProductInventory(String filename) throws Exception {
         products = JsonFileParser.readFile(filename);
    }

    public String findProduct(String name){
        Product product = products.get(name);
        if (product == null){
            return "Product was not found. Please try again.";
        }
        else{
            return String.format("Name: %s\nPrice: $%.2f\nQuantity On Hand: %d\n", product.getName(), product.getPrice(),
                product.getQuantity());
        }
    }
}
