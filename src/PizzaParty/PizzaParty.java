package PizzaParty;
import java.util.Scanner;

/**
 * Prompt for number of people, number of pizzas, and slices per pizza.
 * Divide the pizza evenly displaying how much each person should get
 * and show the number of leftover pieces.
 * Created by Yasmin on 6/18/2017.
 */
public class PizzaParty {
    private Scanner s;

    private PizzaParty(){
        s = new Scanner(System.in);
    }

    private class PizzaDivision{
       private int slicesPerPerson;
       private int leftOverPieces;

        private PizzaDivision(){
            slicesPerPerson = 0;
            leftOverPieces = 0;
        }
    }

    private void dividePizza() {
        int numOfPeople = getInput("Enter the number of people: ");
        int numOfPizzas = getInput ("Enter the number of pizzas: ");
        int numOfSlicesPerPizza = getInput("Enter the number of slices per pizza: ");
        PizzaDivision p = calculate(numOfPeople, numOfPizzas, numOfSlicesPerPizza);
        print ("Each person gets " + p.slicesPerPerson + " slices of pizza.");
        print ("There are " + p.leftOverPieces + " leftover pieces.");
    }


    private Integer getInput(String prompt){
        System.out.println(prompt);
        return s.nextInt();
    }

    private PizzaDivision calculate(int people, int pizzas, int slices){
        int totalSlices = pizzas * slices;
        PizzaDivision p = new PizzaDivision();
        p.slicesPerPerson = totalSlices / people;
        p.leftOverPieces = totalSlices % people;
        return (p);
    }

    private void print(String message){
       System.out.println(message);
    }

    public static void execute(){
        PizzaParty party = new PizzaParty();
        party.dividePizza();
    }
}
