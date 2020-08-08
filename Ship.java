/**
 * Write a description of class Ship here.
 * In this class the attributes of a ship is written along with accessor & mutator methods.
 * @author (Anik Dey Sarker)
 * @version (21/10/2018)
 */
public class Ship
{
    // instance variable
    private String shipName;
    private int xPos;
    private int yPos;
    private int noOfHitsMade;
    private int noOfHitsNeeded;
    public Ship() //Default Constructor
    {
       // initialise instance variables
       shipName="";
       xPos=0;
       yPos = 0;
       noOfHitsMade = 0;
       noOfHitsNeeded=0;
    }
    //Non-default Contructor
    public Ship(String newShipName,int newXPos,int newYPos,int newNoOfHitsMade,int newNoOfHitsNeeded )
    {
       shipName = newShipName;
       xPos = newXPos;
       yPos = newYPos ;
       noOfHitsMade = newNoOfHitsMade;
       noOfHitsNeeded = newNoOfHitsNeeded;
    }
    public void displayShip() //method to display products
    {       
        System.out.println("ShipName : "+shipName);
        System.out.println("xPos : "+xPos);
        System.out.println("yPos : "+yPos);
        System.out.println("noOfHitsMade : "+noOfHitsMade);
        System.out.println("noOfHitsNeeded : "+noOfHitsNeeded);
        System.out.println("============================");        
    }
    public String getShipName() //accessor methods
    {
        return shipName;
    }
    public int getXPos()
    {
        return xPos;
    }
    public int getYPos()
    {
        return yPos;
    }
    public int getNoOfHitsMade()
    {
        return noOfHitsMade;
    }
    public int getNoOfHitsNeeded()
    {
        return noOfHitsNeeded;
    }
    public void setShipName(String newShipName) //mutator methods
    {
        shipName = newShipName;
    }
    public void setXPos(int newXPos)
    {
        xPos = newXPos;
    }
    public void setYPos(int newYPos)
    {
        yPos = newYPos;
    }
    public void setNoOfHitsMade(int newNoOfHitsMade)
    {
        noOfHitsMade = newNoOfHitsMade;
    }
    public void setNoOfHitsNeeded(int newNoOfHitsNeeded)
    {
        noOfHitsNeeded = newNoOfHitsNeeded;
    }
}
