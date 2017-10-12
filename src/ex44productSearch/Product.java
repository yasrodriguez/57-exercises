package ex44productSearch;

/**
 * Product contains the product's name, price, and quantity.
 * Created by Yasmin on 8/28/2017
 */

public class Product {
    private String name;
    private double price;
    private long quantity;

    public Product(String name, double price, long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

      public double getPrice() {
        return price;
    }

      public long getQuantity() {
        return quantity;
    }

    public String toString(){
        return String.format(" [name: %s, price: $%.2f, quantity: %d]\n" ,getName(), getPrice(), getQuantity());
    }
 }
