import java.util.ArrayList;
/**
 * Write a description of class ShipList here.
 * In this class the arrayList is created.Some methods are written for adding ships and for validation
 * @author (Anik Dey Sarker)
 * @version (21/10/2018)
 */
public class ShipList
{
    // instance variables - replace the example below with your own   
    private ArrayList<Ship> ships;

    /**
     * Constructor for objects of class ShipList
     */
    public ShipList()
    {
        ships = new ArrayList<Ship>();// initialise instance variables
    }

    public void addShip(String shipName,int xPos,int yPos,int noOfHitsMade,int noOfHitsNeeded)
    {
        Ship s = new Ship(shipName,xPos,yPos,noOfHitsMade,noOfHitsNeeded);
        ships.add(s);
    }

    public int getShip()
    {
        return ships.size();
    }

    public int checkShip(int x,int y)
    {
        for(Ship ship : ships)
        {
            if(ship.getXPos()==x && ship.getYPos()==y)
            {
                if (ship.getNoOfHitsMade()==ship.getNoOfHitsNeeded())
                {
                    return 10;
                }
                else if (ship.getNoOfHitsMade() >= 1 && ship.getNoOfHitsMade() < ship.getNoOfHitsNeeded())
                {
                    return 20;
                }
                return 30;
            }
        }
        return 40;        
    }

    public void increaseHit(int x,int y)
    {
        for(Ship ship : ships)
        {
            if(ship.getXPos()==x && ship.getYPos()==y)
            {
                int h = ship.getNoOfHitsMade();
                ship.setNoOfHitsMade(h+1);
            }
        }                
    }

    public boolean checkCoordinate(int x,int y)
    {

        for(Ship ship : ships)
        {
            if(ship.getXPos()==x  && ship.getYPos()==y)
            {
                return true;
            }            
        }
        return false;
    }

    public boolean isEmpty()
    {
        return ships.isEmpty();   
    }

    public int checkNotDestroyed()
    {
        for(Ship ship : ships)
        {
            if(ship.getNoOfHitsMade() < ship.getNoOfHitsNeeded())
                return 10;          
        }
        return 20;        
    }

    public void displayShips()
    {
        for(Ship x : ships)
        {
            x.displayShip();
        }
    }

    public void ListOfShips(int index)
    {
        if(index >= 0 && index < ships.size())
        {
            ships.get(index).displayShip();
        }
    }

    public void example(int index1, int index2)
    {
        Ship ship1 = ships.get(index1);
        Ship ship2 = ships.get(index2);
        ships.set(index1,ship2);
        ships.set(index2,ship1);
    }
}
