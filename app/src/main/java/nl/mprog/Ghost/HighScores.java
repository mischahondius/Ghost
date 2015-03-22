//Mischa Hondius
//6053017

package nl.mprog.Ghost;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class HighScores extends Activity {

    public static final String ALL_PLAYERS = "all_players";
    public SharedPreferences allPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        allPlayers = getSharedPreferences(ALL_PLAYERS, MODE_PRIVATE);
        Map <String, ?> highScores = allPlayers.getAll();

        //sort by value
//        Stream<Map.Entry<String,Integer>> sorted = highScores.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue());

        //get TV's
        TextView nameTV = (TextView) findViewById(R.id.nameView);
        TextView scoreTV = (TextView) findViewById(R.id.scoreView);
        
        for (Map.Entry<String, ?> entry : highScores.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            nameTV.setText(nameTV.getText() + "\n" + entry.getKey());
            scoreTV.setText(scoreTV.getText() + "\n" + entry.getValue());

//            nameTV.Text(entry.getKey() + "\n");

        }
        
//        SimpleAdapter adapter = new SimpleAdapter(this, highScores,
//                android.R.layout.simple_list_item_2, from, to);



//        SimpleAdapter hashAdapter = new SimpleAdapter(this, highScores, R.layout.row_layout_2, new String[entry.get], new int[] {R.id.nameView});
//                ListView theListView = (ListView) findViewById(R.id.theListView);
//                theListView.setAdapter(hashAdapter);
//        


//        ListAdapter theAdapter = new MyAdapter(this, playersPlusScores);
//        ListView theListView = (ListView) findViewById(R.id.theListView);
//        theListView.setAdapter(theAdapter);
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
