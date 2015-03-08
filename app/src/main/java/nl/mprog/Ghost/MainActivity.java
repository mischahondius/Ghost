package nl.mprog.Ghost;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //initialize word
    public String currentWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                
                char letterChar = 'A';
                
                //Add letter
                addLetter (letterChar);
                
                Toast.makeText(this, currentWord, Toast.LENGTH_SHORT).show();
                               
                break;
            case R.id.Bbtn:

                break;
            case R.id.Cbtn:

                break;
        }
    }

}