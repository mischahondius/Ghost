package nl.mprog.Ghost;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;



public class Game {

    //initialize shared prefs
    public static final String CURRENT_PLAYERS = "current_players";
    public SharedPreferences preferenceSettings;
    



//Game contains:
public Player player1;
public Player player2;
private Player turn;
private TextView tvToUpdate;

    //game constructor
    public Game (Player player1, Player player2, TextView tvIn, Context ctx){
        
        //access sharedprefs
        preferenceSettings = ctx.getSharedPreferences(CURRENT_PLAYERS, ctx.MODE_PRIVATE);

        this.player1 = player1;
        this.player2 = player2;
        this.tvToUpdate = tvIn;

        //Random pick who's to start game
        switch ( (int)(2*Math.random()) ) {
            case 0:
                this.turn = player1;
                break;
            case 1:
                this.turn = player2;
                break;
        }
        
        //update view
        updateTVTurn();

        //TODO add update sharedprefs
        //Put Unique Player ID's into shared prefs
        SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();
        preferenceEditor.putString("Player 1", this.player1.getID().toString());
        preferenceEditor.putString("Player 2", this.player2.getID().toString());
        preferenceEditor.commit();

    }

    //method, who's turn?
    public Player getTurn(){
        return this.turn;
    }
    
    //method Change turn
    public void changeTurn(){
        if (this.turn == player1){
            this.turn = player2;
        }
        
        else{
            this.turn = player1;
        }
        
        //update TV
        updateTVTurn();

    }

    //method point to opponent
    public void PtToOpponent(){
        //change turn
        this.changeTurn();
        
        //point to opponent
        this.turn.givePoint();
    }

    //method update TV (who's turn)
    public void updateTVTurn(){
        //update TV
        tvToUpdate.setText(this.turn.getName());
    }
    
    //ChangePlayers method
    public void changePlayers(Player player1, Player player2){
    this.player1 = player1;
    this.player2 = player2;
    
    //Update View
    updateTVTurn();

        //TODO add update sharedprefs
//        Put it into shared prefs
//        SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();
//        preferenceEditor.putInt(INT ID PLAYER1);
//        preferenceEditor.putInt(INT ID PLAYER2);
//        preferenceEditor.commit();
    }
}


