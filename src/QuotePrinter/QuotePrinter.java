package QuotePrinter;
import java.util.Scanner;

/**
 * Exercise #3 - Prompt for a quote and author, and print it inside quotes, using escape characters.
 * Created by Yasmin on 6/10/2017.
 */
public class QuotePrinter {
     private void printQuote() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a quote: ");
        String quote = s.nextLine();
        System.out.print("Who said it?: ");
        String author = s.nextLine();
        System.out.println(author + " says," + "\"" + quote + "\"");
    }
    public static void execute(){
         QuotePrinter q = new QuotePrinter();
         q.printQuote();
    }

}
