import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Game here.
 * This is the programme generating class.Here all the validations are done.
 * In this class the method "main()" operates the BattleShip game.
 * @author (Anik Dey Sarker)
 * @version (21/10/2018)
 */
public class Game
{
    private ShipList playerShips;
    private ShipList computerShips;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialise instance variables
        playerShips = new ShipList();
        computerShips = new ShipList();
    }

    public Game(ShipList newPlayerShips,ShipList newComputerShips)
    {
        // initialise instance variables
        playerShips = newPlayerShips;
        computerShips = newComputerShips;
    }

    private int getCoordinateNumber(int minimumValue,int maximumValue)
    {
        CoordinateGenerator coordinateNumber=new CoordinateGenerator(minimumValue , maximumValue);
        return coordinateNumber.coordinatenumber();
    }

    public void main()
    {
        FileIO fio = new FileIO();
        String[] value1 = new String[4];
        System.out.println("+============================================================================================+");
        System.out.println("|                                                                                            |");
        System.out.println("|                            Welcome to Battleship Game -- With a Twist!!                    |");
        System.out.println("|                                                                                            |");
        System.out.println("+============================================================================================+");
        value1 = fio.readFile();
        int size = 0;
        try
        {
            size = Integer.parseInt(value1[0]);
        }
        catch(NumberFormatException exp1)
        {
            System.out.println("NumberFormat not Found");
        }
        System.out.println("Playing grid size set as "+size+ "X"+size);
        //if(size <= 10)
        //{
        int ShipAllowed = 0;
        try
        {
            ShipAllowed = Integer.parseInt(value1[3]);
        }
        catch(NumberFormatException exp2)
        {
            System.out.println("NumberFormat is not Found");
        }
        catch(ArrayIndexOutOfBoundsException exp3)
        {
            System.out.println(exp3);
        }
        System.out.println("Maximum number of ships allowed as "+ShipAllowed);
        boolean multipleHits = true;
        try
        {
        multipleHits = Boolean.parseBoolean(value1[1]);
        }
        catch(ArrayIndexOutOfBoundsException exp4)
        {
            System.out.println(exp4);
        }
        System.out.println("Multiple hits allowed per ships set as :"+multipleHits);
        boolean visibility = true;
        try
        {
        visibility = Boolean.parseBoolean(value1[2]);
        }
        catch(ArrayIndexOutOfBoundsException exp5)
        {
            System.out.println(exp5);
        }
        System.out.println("Computer ships visible : "+visibility);
        System.out.println("Press any key to continue..");
        Input in = new Input();
        in.acceptInput("");

        giveInput(size,ShipAllowed);
        displayplayerShips(size);

        computer(size,ShipAllowed);
        displaycomputerShips(size,visibility);
        String outputData= startGame(size,visibility);
        fio.writeFile(outputData);
        //}
        //else
        //System.out.println("error");
    }

    private String startGame(int size,boolean visibility)
    {
        boolean proceed =true;   
        int PlayerScore = 0;
        int ComputerScore = 0;
        String wonBy="";
        do
        {
            System.out.println();
            System.out.println("Your turn");
            int xPos = getXValue(size); 
            int yPos = getYValue(size);
            int value = computerShips.checkShip(xPos,yPos);
            if(value==10)
            {
                System.out.println("Ship is already destroyed");
            }
            else if(value==20 || value==30)
            {
                System.out.println("Player HITTTT!!!!");
                computerShips.increaseHit(xPos,yPos);
                PlayerScore = PlayerScore + 10;
                System.out.println("Player Score: "+PlayerScore);
                System.out.println();
            }
            else
            {
                System.out.println("Player missss!!!!");
            }            
            displaycomputerShips(size,visibility);
            //checek all the ships are destroyed
            int c = computerShips.checkNotDestroyed();
            if(c==20)
            {
                proceed=false;
                wonBy="Player wins. Final Score Player ("+PlayerScore+") and Computer ("+ComputerScore+")";                
            }
            System.out.println();
            System.out.println("computer's turn");
            int xPos1 = getCoordinateNumber(0,(size - 1)); 
            int yPos1 = getCoordinateNumber(0,(size - 1));
            int value1 = playerShips.checkShip(xPos1,yPos1);
            if(value1==10)
            {
                System.out.println("Ship is already destroyed");
            }
            else if(value1==20 || value1==30)
            {
                System.out.println("computer HITTTT!!!!");
                playerShips.increaseHit(xPos1,yPos1);
                ComputerScore = ComputerScore + 10;
                System.out.println("Computer Score: "+ComputerScore);
                System.out.println();
            }
            else
            {
                System.out.println("Computer missss!!!!");
                System.out.println();
            }
            displayplayerShips(size);
            //checek all the ships are destroyed
            int p = playerShips.checkNotDestroyed();
            if(p==20)
            {
                proceed=false; 
                wonBy="Computer wins. Final Score Player ("+PlayerScore+") and Computer ("+ComputerScore+")";           
            }
        }while(proceed);        
        return wonBy;
    }

    private void giveInput(int size,int ShipAllowed)
    {        
        int shipNo;
        boolean isNotFound=true;
        Input in = new Input();
        for(shipNo = 1; shipNo <= ShipAllowed ; shipNo++)
        {
            String shipName;                    
            do
            {
                System.out.println("Please enter the details for the "+shipNo+" ship:");
                shipName = in.acceptInput("Enter ShipName");
                if(shipName.length() < 3 || shipName.length() > 15 )
                {
                    System.out.println("Re-enter, name out of range------");
                }
                else
                {
                    isNotFound=false;
                }
            }while(isNotFound);
            int noOfHitsNeeded= getCoordinateNumber(1,5);
            isNotFound=true;
            boolean check = true;
            while(check)
            {
                int xPos = getXValue(size);
                int yPos = getYValue(size);
                if(!playerShips.checkCoordinate(xPos, yPos))
                {
                    playerShips.addShip(shipName,xPos,yPos,0,noOfHitsNeeded);  
                    check = false;
                }
                else
                {
                    System.out.println("please try again. the location is already occupied");
                }
            }
        }
    }

    private int getXValue(int size)
    {
        Input in = new Input();
        boolean isNotFound =true;
        int xPos = 0; 
        do
        {
            String xPos1 = in.acceptInput("Ship x Position:");
            try
            {
                xPos = Integer.parseInt(xPos1);
                if(xPos < 0 || xPos > (size-1))
                {
                    System.out.println("Re-enter X------");
                }
                else
                    isNotFound=false;
            }
            catch(Exception e)
            {
                System.out.println("Error Occoured,please type again");
            }
        }while(isNotFound);
        return xPos;
    }

    private int getYValue(int size)
    {
        Input in = new Input();
        boolean isNotFound =true;
        int yPos = 0; 
        do
        {
            String yPos1 = in.acceptInput("Ship y Position:");
            try
            {
                yPos = Integer.parseInt(yPos1);
                if(yPos < 0 || yPos > (size-1))
                {
                    System.out.println("Re-enter y------");
                }
                else
                    isNotFound=false;
            }
            catch(Exception e)
            {
                System.out.println("Error Occoured,please type again");
            }
        }while(isNotFound);
        return yPos;
    }

    private void displayplayerShips(int size)
    {
        System.out.println();
        System.out.println();
        System.out.println("Display Player Grid");
        for(int i=0 ; i<size ; i++)
        {
            for(int j=0 ; j<size ; j++)
            {
                int value = playerShips.checkShip(i,j);
                if(value==10)
                {
                    System.out.print("X");
                }
                else if(value==20)
                    System.out.print("D");
                else if(value==30)
                    System.out.print("O");
                else
                    System.out.print("~");
            }
            System.out.println();
        }
    }

    private void displaycomputerShips(int size,boolean visibility)
    {        
        System.out.println("------------------------------------------------------------------");
        System.out.println();
        System.out.println("Display Computer Grid");
        for(int i=0 ; i<size ; i++)
        {
            for(int j=0 ; j<size ; j++)
            {
                int value = computerShips.checkShip(i,j);
                if(visibility == true)
                {
                    if(value==10)
                    {
                        System.out.print("X");
                    }
                    else if(value==20)
                        System.out.print("D");
                    else if(value==30)
                        System.out.print("O");
                    else
                        System.out.print("~");
                }                
                else
                {
                    System.out.print("~");
                }
            }
            System.out.println();
        }
    }

    private void computer(int size,int ShipAllowed)
    {
        int shipNo;
        boolean isNotFound=true;
        for(shipNo = 1; shipNo <= ShipAllowed; shipNo++)
        {
            String compShip = "comp";
            int xPos = getCoordinateNumber(0,(size - 1));
            int yPos = getCoordinateNumber(0,(size - 1));
            int noOfHitsNeeded = getCoordinateNumber(1,5);
            boolean check = true;
            while(check)
            {
                xPos = getCoordinateNumber(0,(size - 1));
                yPos = getCoordinateNumber(0,(size - 1));
                if(!computerShips.checkCoordinate(xPos,yPos))
                {
                    computerShips.addShip(compShip,xPos,yPos,0,noOfHitsNeeded);  
                    check = false;
                }
                else
                {
                    System.out.println("please try again. the location is already occupied");
                }
            }
        }
    }
}