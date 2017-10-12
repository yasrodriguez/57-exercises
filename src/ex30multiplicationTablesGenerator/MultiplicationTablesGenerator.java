package ex30multiplicationTablesGenerator;

/**
 * Print multiplication tables for numbers 1 to 12.
 * Constraints: Use a nested loop.
 * Created by Yasmin on 8/7/2017
 */

public class MultiplicationTablesGenerator {

    private static void printTables(){

        System.out.print("  ");

        for(int c = 1; c <= 12; c++){

            System.out.printf ("%5s",c);
        }

        System.out.println();

        for (int i = 1; i <= 12; i++){
            System.out.printf ("%2d", i);

            for(int j = 1; j <= 12; j++){
                System.out.printf ("%5d", i * j);
            }

            System.out.println();
        }
    }

    public static void main(String[] args){
        MultiplicationTablesGenerator.printTables();
    }
}
