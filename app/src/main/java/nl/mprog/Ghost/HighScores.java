package nl.mprog.Ghost;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class HighScores extends Activity {

    public static final String ALL_PLAYERS = "all_players";
    public SharedPreferences allPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        //GET NAMES and put in STRING ARRAY
//        String[] playerNames = {"Pushing Daisies", "Better Off Ted", "Twin Peaks", "Freaks and Geeks", "Orpgan Black", "Walking Dad",
//                "Breaking Bad", "The 400", "Alphas", "Life On Mars", "Breaking Bad", "The 400", "Alphas", "Life On Mars", "Breaking Bad", "The 400", "Alphas", "Life On Mars"};

        allPlayers = getSharedPreferences(ALL_PLAYERS, MODE_PRIVATE);
//        Map <String, Integer> playersPlusScores = allPlayers.getAll();

        Map<String, ?> playersPlusScores = allPlayers.getAll();
        
        //for each key, get key and get int
        for (Map.Entry : playersPlusScores.entrySet()) {
            String playerName = name;
            Object playerScore = playersPlusScores.get(key);
        }


        ListAdapter theAdapter = new MyAdapter(this, playersPlusScores);
        ListView theListView = (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(theAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
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
}
