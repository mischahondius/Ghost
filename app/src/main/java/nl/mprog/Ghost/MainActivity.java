package nl.mprog.Ghost;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.HashSet;

public class MainActivity extends Activity {

    //initialize theCurrentWord
    public CurrentInput theCurrentWord;

    //initialize letterchar
    public char letterChar;

    //initialize dictionary
    public Dictionary dutchDictionary;

    //Get textview to change
    public TextView huidigWoordTV;

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

        //get the letter from buttontext
        Button currentBtn = (Button) findViewById(letter.getId());
        letterChar = currentBtn.getText().charAt(0);

        switch (letter.getId()) {
            case R.id.Abtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Bbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Cbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Dbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Ebtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Fbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Gbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Hbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Ibtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Jbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Kbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Lbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Mbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Nbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Obtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Pbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Qbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Rbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Sbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Tbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Ubtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Vbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Wbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Xbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Ybtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.Zbtn:

                //check letter
                //->nog schrijven

                //Als letter ok -> Add letter + pass textview to update
                theCurrentWord.addLetter(letterChar, huidigWoordTV);

                //Check of woord gevormd en of woord lang genoeg is-> speler af
                if ((dutchDictionary.isWord(theCurrentWord.get().toLowerCase())) && (theCurrentWord.getSize() > 3)) {
                    Toast.makeText(this, getString(R.string.winnaarToast), Toast.LENGTH_SHORT).show();

                    //clear (moet restart funtie worden)
                    theCurrentWord.clear(huidigWoordTV);

                } else {
                    Toast.makeText(this, getString(R.string.weSpelenDoorToast), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}