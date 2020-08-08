import java.io.*;
import java.util.Scanner;
import java.lang.*;
/**
 * Write a description of class FileIO here.
 * In this class methods for reading input from file and 
 * writing to outputfile is written
 * @author (Anik Dey Sarker)
 * @version (21/10/2018)
 */
public class FileIO
{
    private String filename = "gamesettings.txt";
    
    /**
     * Constructor for objects of class FileIO
     */
    public FileIO(String newFilename)
    {
        filename = newFilename;
        filename=filename.replace("\u0000","");
    }

    public FileIO()
    {
    }

    public void writeFile(String outputData)
    {
        String output = "gameoutput.txt";
        try
        {
            PrintWriter outputFile = new PrintWriter(output);
            try
            {
                outputFile.println(outputData);
            }
            finally
            {
                outputFile.close();
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public String[] readFile()
    {
        String output="";
        String[] value = new String[4];
        try
        {
            FileReader inputFile = new FileReader(filename);
            try
            {
                Scanner parser = new Scanner(inputFile);
                //while(parser.hasNext())
                //{                   
                    output = output + parser.next();
                //}
                value = output.split(",");
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException e)
        {
            System.out.println("Something went wrong unexpectedly...");
        }
        return value;
    }
}