package ex8pizzaParty;
import java.util.Scanner;

/**
 * Prompt for number of people, number of pizzas, and slices per pizza.
 * Divide the pizza evenly displaying how much each person should get
 * and show the number of leftover pieces.
 * Created by Yasmin on 6/18/2017.
 */
public class PizzaParty {
    private Scanner s;
    private int numOfPeople;
    private int numOfPizzas;
    private int numOfSlicesPerPizza;
    private PizzaDivision p;

    private PizzaParty(){
        numOfPeople = 0;
        numOfPizzas = 0;
        numOfSlicesPerPizza = 0;
        initialize();
    }

    public PizzaParty(int numOfPeople, int numOfPizzas, int numOfSlicesPerPizza){
        this.numOfPeople = numOfPeople;
        this.numOfPizzas = numOfPizzas;
        this.numOfSlicesPerPizza = numOfSlicesPerPizza;
        initialize();
    }

    private void initialize(){
        s = new Scanner(System.in);
        p = new PizzaDivision(0,0);
    }
    public class PizzaDivision{
       private int slicesPerPerson;
       private int leftOverPieces;

        private PizzaDivision(int slices, int leftovers){
            slicesPerPerson = 0;
            leftOverPieces = 0;
        }

        public int getSlices(){
            return slicesPerPerson;
        }

        public int getLeftOvers(){
            return leftOverPieces;
        }
    }

    private void getInput(){
        numOfPeople = prompt("Enter the number of people: ");
        numOfPizzas = prompt ("Enter the number of pizzas: ");
        numOfSlicesPerPizza = prompt("Enter the number of slices per pizza: ");
    }

    private Integer prompt(String prompt){
        System.out.println(prompt);
        return s.nextInt();
    }

    private void calculate (){
        int totalSlices = numOfPizzas * numOfSlicesPerPizza;
        p.slicesPerPerson = totalSlices / numOfPeople;
        p.leftOverPieces = totalSlices % numOfPeople;
    }

    private void print(String message){
       System.out.println(message);
    }
    
    private void results(){
        print ("Each person gets " + p.slicesPerPerson + " slices of pizza.");
        print ("There are " + p.leftOverPieces + " leftover pieces.");
    }

    public static void execute(){
        PizzaParty party = new PizzaParty();
        party.getInput();
        party.calculate();
        party.results();
    }

    public PizzaDivision executeTest(){
        calculate();
        return p;
    }
}
