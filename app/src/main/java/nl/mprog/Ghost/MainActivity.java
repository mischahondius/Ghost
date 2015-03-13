package nl.mprog.Ghost;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class MainActivity extends Activity {

    //initialize theCurrentWord
    public CurrentInput theCurrentWord;

    //initialize letterchar
    public char letterChar;

    //initialize dictionary
    public Dictionary dutchDictionary;

    //initialize textview huidigwoord to change
    public TextView huidigWoordTV;

    //initialize TV huidigeSpelerTV
    public TextView huidigeSpelerTV;

    //Initialize currentGame
    public Game currentGame;

    //Initialize player1
    public Player player1;

    //initialize player2
    public Player player2;

    //initialize remainingwords
    public HashSet<String> remainingWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load dictionary
        dutchDictionary = new Dictionary(this);

        //Load theCurrentWord
        theCurrentWord = new CurrentInput();

        //Load remainingwords
        remainingWords = dutchDictionary.getWords();

        //Load textview huidigwoord
        huidigWoordTV = (TextView) findViewById(R.id.huidigWoord);

        //TEMP hardcode create player1
        player1 = new Player("Hardcoded Naam1");

        //TEMP hardcode create player2
        player2 = new Player("Hardcoded Naam2");

        //Get textView huidigeSpelerTV
        huidigeSpelerTV = (TextView) findViewById(R.id.huidigeSpeler);

        //Create new game
        currentGame = new Game(player1, player2, huidigeSpelerTV);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.restart) {
            restart();
        }

        return super.onOptionsItemSelected(item);
    }

    //Restart method
    public void restart() {
        //Clear word
        theCurrentWord.clear(huidigWoordTV);

        //Create new game
        currentGame = new Game(player1, player2, huidigeSpelerTV);

        //TV update who has the turn
        huidigeSpelerTV.setText(currentGame.getTurn().getName());

        //load in new dictionary
        dutchDictionary = new Dictionary(this);

        //Refill remaining words
        remainingWords = dutchDictionary.getWords();

    }

    //on letter clicked
    public void letterClicked(View letter) {

        //get the letter from buttontext
        Button currentBtn = (Button) findViewById(letter.getId());
        letterChar = Character.toLowerCase(currentBtn.getText().charAt(0));

        //Add letter + pass textview to update
        theCurrentWord.addLetter(letterChar, huidigWoordTV);

        //iterate through set, throw away unnecessary words
        Iterator<String> itr = remainingWords.iterator();
        while (itr.hasNext()) {

   
            //Load next word into iterator element
            String tmpWoord = itr.next();

            //check of woord niet te klein is
            if ((tmpWoord.length()) <= (theCurrentWord.getSize())-1) {
                
                //skip to next
                continue;
            }
        
            //Remove all unnecessary words
            if (tmpWoord.charAt(theCurrentWord.getSize() - 1) != letterChar) {

                //remove element
                itr.remove();
            }
        }

        //check whether remaining wordslist is is now empty or 1
        //If list is Empty or 1, false letter or correct word -> Win for opponent
        if ((remainingWords.isEmpty()) || (remainingWords.size() == 1)) {
            
            //Opponent won, appoint a point to opponent
            currentGame.PtToOpponent();

            //Toast winner and how many points winner has in total
            Toast.makeText(this, currentGame.getTurn().getName() + " won and has now " + Integer.toString(currentGame.getTurn().getPoints()) + " points.", Toast.LENGTH_LONG).show();

            //Restart game
            restart();
        }

        //else, we continue to play
        else {

            //4 letters or more 
            if (theCurrentWord.getSize() > 3) {

                //in dictionary as single word??
                if (dutchDictionary.isWord(theCurrentWord.get())) {

                    //if in dictionary, FAIL! Win for opponent
                    //Opponent won, appoint a point to opponent
                    currentGame.PtToOpponent();

                    //Toast winner and how many points winner has in total
                    Toast.makeText(this, currentGame.getTurn().getName() + " won and has now " + Integer.toString(currentGame.getTurn().getPoints()) + " points.", Toast.LENGTH_LONG).show();

                    //Restart game
                    restart();
                }
                //else, 4 letters or more and more words left -> play through
                else {
                    //Change turn, change turn TV
                    currentGame.changeTurn();
                }
            }

            //Else (If not 4 letters minimum -> play through)
            else {
                //Change turn, change turn TV
                currentGame.changeTurn();
            }
        }
    }
}