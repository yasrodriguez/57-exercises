package SayingHello;
import java.util.Scanner;


/**
 * Exercise 1 - Prompt for the user's name and print a greeting with their name
 */
public class SayingHello {

   private void sayHello(){
        Scanner s = new Scanner(System.in);
        System.out.print("What is your name?");
        String name = s.next();
        System.out.println("Hi " + name + ", nice to meet you!");
    }

    public static void execute(){
       SayingHello hi = new SayingHello();
       hi.sayHello();
    }
}
