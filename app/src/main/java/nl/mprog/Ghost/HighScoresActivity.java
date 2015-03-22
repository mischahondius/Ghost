//Mischa Hondius
//6053017

package nl.mprog.Ghost;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.Map;

public class HighScoresActivity extends Activity {

    public static final String ALL_PLAYERS = "all_players";
    public SharedPreferences allPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        allPlayers = getSharedPreferences(ALL_PLAYERS, MODE_PRIVATE);
        Map <String, ?> highScores = allPlayers.getAll();

        //get TV's
        TextView nameTV = (TextView) findViewById(R.id.nameView);
        TextView scoreTV = (TextView) findViewById(R.id.scoreView);
        
        for (Map.Entry<String, ?> entry : highScores.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            nameTV.setText(nameTV.getText() + "\n" + entry.getKey());
            scoreTV.setText(scoreTV.getText() + "\n" + entry.getValue());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}