//Mischa Hondius
//6053017

package nl.mprog.Ghost;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChangePlayersActivity extends Activity {

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
        setContentView(R.layout.activity_change_players);

        //GET PLAYER INFO
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("Player 1");
        player2Name = intent.getStringExtra("Player 2");
        
        //Get TV's to fill in current names
        editPlayer1TV = (TextView)findViewById(R.id.player1NameTV);
        editPlayer2TV = (TextView)findViewById(R.id.player2NameTV);

        //Set current names
        editPlayer1TV.setText(player1Name);
        editPlayer2TV.setText(player2Name);   
        
        //Get Spinner TVs to fill up with selectable names
        spinner1 = (Spinner) findViewById(R.id.spinnerTV1);
        spinner2 = (Spinner) findViewById(R.id.spinnerTV2);

        //Set spinner with all possible names
        //access sharedprefs and put keys and values in map
        getAllPlayers();
        Map<String, ?> highScores = allPlayers.getAll();
        
        //create new Arraylist to store names
        List<String> nameList = new ArrayList<>();
        
        //Put names in nameslist
        for (Map.Entry<String, ?> entry : highScores.entrySet()) {
            nameList.add(entry.getKey());
        }
        
        //Create adapter for spinner and set it
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
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
                editPlayer1TV.setText("You've selected NOTHING");
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
                editPlayer2TV.setText("You've selected NOTHING");
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

        //Check if valid name
        if (!Name.isValid((newNamePlayer1)) || !Name.isValid((newNamePlayer2))) {
            if (!Name.isValid(newNamePlayer1)){
                editPlayer1TV.setError("Invalid Name");}
            if (!Name.isValid(newNamePlayer2)){
                editPlayer2TV.setError("Invalid Name");}
            return;
        }

        //if same name, toast error message
        if (newNamePlayer1.equals(newNamePlayer2)){
            Toast.makeText(getApplicationContext(), "You can't use the same name", Toast.LENGTH_LONG).show();
        }

        else {
            Intent data = new Intent();
            data.putExtra("Player 1", newNamePlayer1);
            data.putExtra("Player 2", newNamePlayer2);
            setResult(RESULT_OK, data);
            super.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_change_players, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    
    public void getAllPlayers(){
        //access sharedprefs
        allPlayers = getSharedPreferences(ALL_PLAYERS, MODE_PRIVATE);
    }
}