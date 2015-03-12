package nl.mprog.Ghost;

/**
 * Created by Equifilm on 12-3-2015.
 */
public class Game {

//    GAME
//    *currentPlayer1
//    *currentPlayer2
//    *switch?? player1/player2
//
//    -currentUsers?
//            -WhosTurn?
//            -Win?
//            -newRound


//Game contains:
public Player player1;
public Player player2;    
public Player turn;

    //game constructor
    public Game (Player player1, Player player2){
    
        this.player1 = player1;
        this.player2 = player2;
        this.turn = player1;
    
    
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
                

    }

}
