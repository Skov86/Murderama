package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Monster monsterInRoom;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        monsterInRoom = new Monster(100,1);
    }
    
    public Room(String description, String start) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        monsterInRoom = new Monster(100,1);
        
    }
    
    public Room(String description, Monster monster) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        monsterInRoom = monster;
        
    }
    
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}
