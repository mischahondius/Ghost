package nl.mprog.Ghost;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;

public class MainActivity extends Activity {

    //initialize shared prefs
    //Standard Language is Dutch
    private static final String PREFS = "prefs";
    private String PREF_LANGUAGE = "NL";
    private SharedPreferences preferenceSettings;

    //initialize theCurrentWord
    public CurrentInput theCurrentWord;

    //initialize letterchar
    public char letterChar;

    //initialize dictionary
    public Dictionary currentDictionary;

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
        
        //TODO setcontentview -> playeractivity
        
        setContentView(R.layout.activity_main);

        //access sharedprefs
        preferenceSettings = getSharedPreferences(PREFS, MODE_PRIVATE);

        // If there are no shared prefs saved
        if(preferenceSettings == null){
            //put standard language in sharedprefs
            SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();
            preferenceEditor.putString("PREF_LANGUAGE", "NL");
            preferenceEditor.commit();        
        }
                
        //Load dictionary
        currentDictionary = new Dictionary(this, preferenceSettings.getString("PREF_LANGUAGE", "NL"));

        //Load theCurrentWord
        theCurrentWord = new CurrentInput();

        //Load remainingwords
        remainingWords = currentDictionary.getWords();

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

        //Players option Clicked
        if (id == R.id.players){
        //load new screen
            setContentView(R.layout.activity_change_players);
            //TODO intent? we moeten wat terugkrijgen denk ik? Of andere activity maken?

        }
        
        //Restart option clicked
        if (id == R.id.restart) {
            restart();
        }
        
        //Language change option clicked
        if (id == R.id.language) {
            
            //ENGLISH or DUTCH view options select
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Language");
            alert.setMessage("Please choose:");

            // Option Dutch 
            alert.setPositiveButton("Nederlands", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int whichButton) {
                    
                    // Put it into shared prefs
                    SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();
                    preferenceEditor.putString("PREF_LANGUAGE", "NL");
                    preferenceEditor.commit();

                    //restart game with new language
                    restart();
                    
                    // Confirm language
                    Toast.makeText(getApplicationContext(), "The current language is now Dutch!", Toast.LENGTH_LONG).show();
                }
            });

            // Option English
            alert.setNegativeButton("English", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int whichButton) {
                    
                    // Put it into shared prefs                    
                    SharedPreferences.Editor preferenceEditor = preferenceSettings.edit();
                    preferenceEditor.putString("PREF_LANGUAGE", "ENG");
                    preferenceEditor.commit();

                    //restart game with new language
                    restart();
                    
                    // Confirm language
                    Toast.makeText(getApplicationContext(), "The current language is now English!", Toast.LENGTH_LONG).show();

                }
            });

            alert.show();
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
        currentDictionary = new Dictionary(this, preferenceSettings.getString("PREF_LANGUAGE", "NL"));
        
        //check if language is changed
        Log.i("Language is", preferenceSettings.getString("PREF_LANGUAGE", "NL"));

        //Refill remaining words
        remainingWords = currentDictionary.getWords();

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
                
                //remove smaller word
                itr.remove();
            }
        
            //Remove all unnecessary words
            else if (tmpWoord.charAt(theCurrentWord.getSize() - 1) != letterChar) {

                //remove element
                itr.remove();
            }
            
        }

        //check whether remaining wordslist is is now empty or 1
        //If list is Empty or 1, false letter or correct word -> Win for opponent
//      if ((remainingWords.isEmpty()) || (remainingWords.size() == 1)) {
        if (remainingWords.isEmpty()) {

            //Opponent won, appoint a point to opponent
            currentGame.PtToOpponent();

            //Toast winner and how many points winner has in total
            Toast.makeText(this, currentGame.getTurn().getName() + " won and has now " + Integer.toString(currentGame.getTurn().getPoints()) + " points.", Toast.LENGTH_LONG).show();

            //Countdown and restart in order to keep hold of the current word
            new android.os.CountDownTimer(1500, 1500) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    restart();
                }
            }.start();            
        }
        


        //else, we continue to play
        //not empty, so 1 or more words
        else {

            //4 letters or more
            if (theCurrentWord.getSize() > 3) {

                //in dictionary as single word??
                if (remainingWords.contains(theCurrentWord.get())) {

                    //if in dictionary, FAIL! Win for opponent
                    //Opponent won, appoint a point to opponent
                    currentGame.PtToOpponent();

                    //Toast winner and how many points winner has in total
                    Toast.makeText(this, currentGame.getTurn().getName() + " won and has now " + Integer.toString(currentGame.getTurn().getPoints()) + " points.", Toast.LENGTH_LONG).show();

                    //Countdown and restart in order to keep hold of the current word
                    new android.os.CountDownTimer(1500, 1500) {

                        public void onTick(long millisUntilFinished) {
                        }

                        public void onFinish() {
                            restart();
                        }
                    }.start();
                }
                //else, 4 letters or more and more words left -> play through
                else {
                    //Change turn, change turn TV
                    currentGame.changeTurn();
                }
            }

            //Else if smaller than 4, play through
            else {

                //Change turn, change turn TV
                currentGame.changeTurn();
            }
        }
    }
}