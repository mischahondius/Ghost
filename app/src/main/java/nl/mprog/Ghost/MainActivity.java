package nl.mprog.Ghost;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.HashSet;

public class MainActivity extends Activity {

    //initialize word
    public String currentWord = "";

    //initialize letterchar
    char letterChar;

    //the dictionary initialize
    //Create hashset for dictionary
    public HashSet<String> dutchDictionary = new HashSet<String>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get and save dictionary
        dutchDictionary = Dictionary.getDictionary(this);
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
        if (id == R.id.Opties) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    


    
    //isValid letter check function
    public boolean isValid (char lettertoAdd){
        
        //
        return true;
    }
    
    //add letter 
    public void addLetter (char letterToAdd){
        currentWord = currentWord + letterToAdd;  
        
        //update textView huidigwoord
        //get tv
        TextView currentWordTV = (TextView) findViewById(R.id.huidigWoord);
        
        //set new word
        currentWordTV.setText(currentWord);
        
        }
    
    //on letter clicked
    public void letterClicked(View letter) {
        switch (letter.getId()) {
            case R.id.Abtn:
                
                //get text                             
                letterChar = 'A';
                
                //test dictionary toast
                
                
                //is validWord?
                
                //Add letter
                addLetter (letterChar);
                
                break;
            case R.id.Bbtn:
                letterChar = 'B';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;
            case R.id.Cbtn:

                //get text                             
                letterChar = 'C';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Dbtn:

                //get text                             
                letterChar = 'D';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Ebtn:

                //get text                             
                letterChar = 'E';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Fbtn:

                //get text                             
                letterChar = 'F';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Gbtn:

                //get text                             
                letterChar = 'G';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Hbtn:

                //get text                             
                letterChar = 'H';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Ibtn:

                //get text                             
                letterChar = 'I';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Jbtn:

                //get text                             
                letterChar = 'J';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Kbtn:

                //get text                             
                letterChar = 'K';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Lbtn:

                //get text                             
                letterChar = 'L';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Mbtn:

                //get text                             
                letterChar = 'M';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Nbtn:

                //get text                             
                letterChar = 'N';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Obtn:

                //get text                             
                letterChar = 'O';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Pbtn:

                //get text                             
                letterChar = 'P';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Qbtn:

                //get text                             
                letterChar = 'Q';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Rbtn:

                //get text                             
                letterChar = 'R';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Sbtn:

                //get text                             
                letterChar = 'S';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Tbtn:

                //get text                             
                letterChar = 'T';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Ubtn:

                //get text                             
                letterChar = 'U';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Vbtn:

                //get text
                letterChar = 'V';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Wbtn:

                //get text                             
                letterChar = 'W';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Xbtn:

                //get text                             
                letterChar = 'X';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Ybtn:

                //get text                             
                letterChar = 'Y';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;

            case R.id.Zbtn:

                //get text                             
                letterChar = 'Z';

                //is validWord?

                //Add letter
                addLetter (letterChar);

                break;
            
        }
    }

}