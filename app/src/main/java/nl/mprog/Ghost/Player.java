//Mischa Hondius
//6053017

package nl.mprog.Ghost;

import android.content.Context;
import android.content.SharedPreferences;

public class Player {
    public static final String ALL_PLAYERS = "all_players";
    public SharedPreferences allPlayers;
       
    //Player contains
    private String name;
    private int points;

    //Player constructor
    public Player(String newName, Context ctx){
        this.name = newName;
        this.points = 0;

        //access sharedprefs
        allPlayers = ctx.getSharedPreferences(ALL_PLAYERS, ctx.MODE_PRIVATE);

        //save to highscores
        saveToHighscores();
    }
    
    public void reLoad (String oldName, int oldPoints){
        this.name = oldName;
        this.points = oldPoints;
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
        
        //save to highscores
        saveToHighscores();
    }

    //Get points method
    public int getPoints(){
        return this.points;
    }

    public void saveToHighscores() {
        SharedPreferences.Editor editor = allPlayers.edit();
        editor.putInt(this.name, this.points);
        editor.commit();
    }
}