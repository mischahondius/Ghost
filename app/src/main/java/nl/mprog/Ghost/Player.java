package nl.mprog.Ghost;

import android.content.Context;

/**
 * Created by Equifilm on 12-3-2015.
 */
public class Player {
    
    
    //Player
//    -name
//    -points
//    -add points
    
    //Player contains
    private String name;
    private int points;

    //Player constructor
    public Player(String newName){
        this.name = newName;
        this.points = 0;
    }
    
    //getName method
    public String getName(){
        return this.name;
     }
    
    
    //give point method
    public void givePoint(){
        this.points++;
        
    }

    //Get points tmethod
    public int getPoints(){
        return this.points;
    }


}
