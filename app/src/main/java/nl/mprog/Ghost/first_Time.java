//Mischa Hondius
//6053017

package nl.mprog.Ghost;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class first_Time extends Activity {

    public static final String ALL_PLAYERS = "all_players";
    public SharedPreferences allPlayers;

    //Initialize TV's to edit
    TextView editPlayer1TV;
    TextView editPlayer2TV;

    //Strings old names
    String player1Name;
    String player2Name;

    Spinner spinner1;
    Spinner spinner2;

    //spinner first time check
    int check;
    int check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__time);

        //GET PLAYER INFO
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("Player 1");
        player2Name = intent.getStringExtra("Player 2");

        //Get TV's to fill in current names
        editPlayer1TV = (TextView)findViewById(R.id.player1NameTVFirst);
        editPlayer2TV = (TextView)findViewById(R.id.player2NameTVFirst);

        //Set current names
        editPlayer1TV.setHint("Jan Alleman");
        editPlayer2TV.setHint("Jan Modaal");
        

        //Get Spinner TVs to fill up with selectable names
        spinner1 = (Spinner) findViewById(R.id.spinnerTV1First);
        spinner2 = (Spinner) findViewById(R.id.spinnerTV2First);


        //Set spinner with all possible names
        //get names

        //access sharedprefs and put keys and values in map
        getAllPlayers();
        Map<String, ?> highScores = allPlayers.getAll();

        //create new Arraylist to store names
        List<String> nameList = new ArrayList<String>();

        //Put names in nameslist
        for (Map.Entry<String, ?> entry : highScores.entrySet()) {
            nameList.add(entry.getKey());
        }

        //Create adapter for spinner and set it
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);

        //Set spinner listener1
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                check++;
                if(check>1) {
                    String selectedNamePlayerOne = (String) parent.getItemAtPosition(pos);
                    editPlayer1TV.setText(selectedNamePlayerOne);}
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Set spinner listener2
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                check2++;
                if(check2>1) {
                    String selectedNamePlayerTwo = (String) parent.getItemAtPosition(pos);
                    editPlayer2TV.setText(selectedNamePlayerTwo);}
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



    }

    public void onSubmit(View submitbutton){

        //Finish activity and return result
        finish();

    }

    public void finish() {

        //Access Sharedprefs all playeres
        getAllPlayers();

        //delete old instance of player in sharedprefs 
        SharedPreferences.Editor editor = allPlayers.edit();
        editor.remove(player1Name);
        editor.remove(player2Name);
        editor.commit();

        //get TV player 1 & 2 inputted names
        String newNamePlayer1 = editPlayer1TV.getText().toString();
        String newNamePlayer2 = editPlayer2TV.getText().toString();
        
        //if empty
        //if same name

        Intent data = new Intent();
        data.putExtra("Player 1", newNamePlayer1);
        data.putExtra("Player 2", newNamePlayer2);
        setResult(RESULT_OK, data);
        super.finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first__time, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void getAllPlayers(){

        //access sharedprefs
        allPlayers = getSharedPreferences(ALL_PLAYERS, MODE_PRIVATE);

    }
}
