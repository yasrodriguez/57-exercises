package ex30multiplicationTablesGenerator;

/**
 * Print multiplication tables for numbers 1 to 12.
 * Constraints: Use a nested loop.
 * Created by Yasmin on 8/7/2017
 */

public class MultiplicationTablesGenerator {

    public static void printTables(){

        for (int i = 1; i <= 12; i++){

            for(int j = 1; j <= 12; j++){
                System.out.println (i + " x " + j + " = " + (i * j));
            }

            System.out.println();
        }
    }

    public static void main(String[] args){
        MultiplicationTablesGenerator.printTables();
    }
}
