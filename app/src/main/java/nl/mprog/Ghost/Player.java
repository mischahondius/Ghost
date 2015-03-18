package nl.mprog.Ghost;

import android.content.Context;
import java.util.UUID;

public class Player {
    
    
    //Player
//    -name
//    -points
//    -add points
    
    //Player contains
    private String name;
    private int points;
    private UUID id;

    //Player constructor
    public Player(String newName){
        this.name = newName;
        this.points = 0;
        this.id = generateID();
    }
    
    //getName method
    public String getName(){
        return this.name;
     }
    
    //setName method
    public void setName(String newName){
        this.name = newName;
    }
    
    
    //give point method
    public void givePoint(){
        this.points++;
        
    }

    //Get points method
    public int getPoints(){
        return this.points;
    }

    //Create unique ID method
    private static final UUID generateID(){
        UUID newID = UUID.randomUUID();
        return newID;
    }
    
    //get ID function
    public UUID getID(){
        return this.id;
    }
}
