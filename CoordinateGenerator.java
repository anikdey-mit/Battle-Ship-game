import java.util.Random;
/**
 * Write a description of class CoordinateGenerator here.
 * In this class the method for randomly generated coordinate number is written
 * @author (Anik Dey Sarker)
 * @version (21/10/2018)
 */
public class CoordinateGenerator
{
    private int minimumValue;
    private int maximumValue;
    
    // default Constructor    
    public CoordinateGenerator()
    {
       minimumValue = 0;
       maximumValue = 0;
    }
    public CoordinateGenerator(int newMinimumValue , int newMaximumValue) //non-default Constructor
    {
       minimumValue = newMinimumValue;
       maximumValue = newMaximumValue;
    }
    public int coordinatenumber() //method to generate random number
    {
        Random rnd = new Random();
        int coordinatenumber = rnd.nextInt(maximumValue + 1 - minimumValue) + minimumValue;
        return coordinatenumber;
    }    
    public int getMinimumValue() //accessor methods
    {
       return minimumValue;
    }
    public int getMaximumValue()
    {
        return maximumValue;
    }
    public void setMinimumValue(int newMinimumValue) //mutator methods
    {
        minimumValue = newMinimumValue;
    }
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }   
}