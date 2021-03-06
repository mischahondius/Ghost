//Mischa Hondius
//6053017

package nl.mprog.Ghost;

import android.widget.TextView;

public class Game {

//Game contains:
public Player player1;
public Player player2;
private Player turn;
private TextView tvToUpdate;

    //game constructor
    public Game (Player player1, Player player2, TextView tvIn){
        
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
        
    //Save new players to sharedprefs, Highscores
    this.player1.saveToHighscores();
    this.player2.saveToHighscores();

    //Update View
    updateTVTurn();
    }
}