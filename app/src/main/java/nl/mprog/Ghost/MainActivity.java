package nl.mprog.Ghost;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load dictionary
        dutchDictionary = new Dictionary(this);

        //Load theCurrentWord
        theCurrentWord = new CurrentInput();

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
    public void restart(){
        //Clear word
        theCurrentWord.clear(huidigWoordTV);

        //Create new game
        currentGame = new Game(player1, player2, huidigeSpelerTV);

        //TV update who has the turn
        huidigeSpelerTV.setText(currentGame.getTurn().getName());
     }
    
    //on letter clicked
    public void letterClicked(View letter) {

        //get the letter from buttontext
        Button currentBtn = (Button) findViewById(letter.getId());
        letterChar = currentBtn.getText().charAt(0);

        //check letter
        //->nog schrijven

        //Als letter ok -> Add letter + pass textview to update
        theCurrentWord.addLetter(letterChar, huidigWoordTV);

        //Check of woord gevormd en of woord lang genoeg is-> speler af
        if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {

            //Opponent won, appoint a point to opponent
            currentGame.PtToOpponent();

            //Toast winner and how many points winner has in total
            Toast.makeText(this, currentGame.getTurn().getName() + " won and has now " + Integer.toString(currentGame.getTurn().getPoints()) + " points.", Toast.LENGTH_SHORT).show();

            //Restart game
            restart();

        } else {
            //Change turn, change turn TV
            currentGame.changeTurn();
        }
    }
}