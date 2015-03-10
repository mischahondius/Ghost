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

public class MainActivity extends Activity{

    //initialize theCurrentWord
    public CurrentInput theCurrentWord;

    //initialize letterchar
    public char letterChar;
    
    //initialize dictionary
    public Dictionary dutchDictionary;

    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load dictionary
        dutchDictionary = new Dictionary(this);

        //Load theCurrentWord
        theCurrentWord = new CurrentInput();

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

    //on letter clicked
    public void letterClicked(View letter) {
        switch (letter.getId()) {
            case R.id.Abtn:

                //get text
                letterChar = 'A';

                //test dictionary toast

//                if (dutchDictionary.isWord("test")) {
//
//                   Toast.makeText(this, "contains the word test" ,Toast.LENGTH_LONG).show();
//                }
//
//                else  {
//
//                    Toast.makeText(this, "Does NOT contain nllkoo" ,Toast.LENGTH_LONG).show();
//                }

                //is validWord?
                
                //Get textview to change
                TextView huidigWoordTV;
                huidigWoordTV = (TextView)findViewById(R.id.huidigWoord);
                
                if (huidigWoordTV == null) {

                    Toast.makeText(this, "huidigwoord is leeg", Toast.LENGTH_LONG).show();
                }
                
                else {
                //Add letter
                theCurrentWord.addLetter(letterChar);

                //Get size test
                String huidigeSize = String.valueOf(theCurrentWord.getSize());
                Toast.makeText(this, huidigeSize, Toast.LENGTH_SHORT).show();

//
//                  //set new word, update
//                   huidigWoordTV.setText(theCurrentWord.get());

                }
                
                
                break;
            
            
//            case R.id.Bbtn:
//                letterChar = 'B';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar));
//
//                //test toast current inputsize
//                Toast.makeText(this, "Current inputsize = " + theCurrentWord.getSize(),Toast.LENGTH_LONG).show();
//
//                break;
            
//            case R.id.Cbtn:
//
//                //get text
//                letterChar = 'C';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Dbtn:
//
//                //get text
//                letterChar = 'D';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Ebtn:
//
//                //get text
//                letterChar = 'E';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Fbtn:
//
//                //get text
//                letterChar = 'F';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Gbtn:
//
//                //get text
//                letterChar = 'G';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Hbtn:
//
//                //get text
//                letterChar = 'H';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Ibtn:
//
//                //get text
//                letterChar = 'I';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Jbtn:
//
//                //get text
//                letterChar = 'J';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Kbtn:
//
//                //get text
//                letterChar = 'K';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Lbtn:
//
//                //get text
//                letterChar = 'L';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Mbtn:
//
//                //get text
//                letterChar = 'M';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Nbtn:
//
//                //get text
//                letterChar = 'N';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Obtn:
//
//                //get text
//                letterChar = 'O';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Pbtn:
//
//                //get text
//                letterChar = 'P';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Qbtn:
//
//                //get text
//                letterChar = 'Q';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Rbtn:
//
//                //get text
//                letterChar = 'R';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Sbtn:
//
//                //get text
//                letterChar = 'S';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Tbtn:
//
//                //get text
//                letterChar = 'T';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Ubtn:
//
//                //get text
//                letterChar = 'U';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Vbtn:
//
//                //get text
//                letterChar = 'V';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Wbtn:
//
//                //get text
//                letterChar = 'W';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Xbtn:
//
//                //get text
//                letterChar = 'X';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Ybtn:
//
//                //get text
//                letterChar = 'Y';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;
//
//            case R.id.Zbtn:
//
//                //get text
//                letterChar = 'Z';
//
//                //is validWord?
//
//                //Add letter
//                theCurrentWord.addLetter(letterChar);
//
//                break;

        }
    }

}