import java.util.Scanner;
/**
 * Write a description of class Input here.
 * This class is used for accepts inputs from user
 * @author (Anik Dey Sarker)
 * @version (21/10/2018)
 */
public class Input
{

    /**
     * Constructor for objects of class Input
     */
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String acceptInput(String displayMessage)
    {
       Scanner console = new Scanner(System.in);
       System.out.println(displayMessage);
       String input = console.nextLine();
       return input;
    }
}