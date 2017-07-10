package experiments;
import java.io.*;
import java.util.Scanner;

/**
 * Practice redirecting Input Stream.
 * Created by Yasmin on 7/8/2017.
 */
public class InputRedirect
{
    private  String input;
    private  Scanner s;

    private InputRedirect()
    {
        input = "";
        s =  new Scanner(System.in);
    }

    public static void main(String[] args)
    {
        InputRedirect ir = new InputRedirect();
        ir.getInput();
        ir.feedInput("Hello");
    }

    private void getInput()
    {
        print ("Enter your name: ");
        input = s.next();
        print("You entered " + input);
    }

    private void feedInput(String input)
    {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        s = new Scanner (is);
        String programInput = s.next();
        print("The program entered " + programInput);
    }


    public void print(String message)
    {
        System.out.println(message);
    }
}

