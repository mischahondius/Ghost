package nl.mprog.Ghost;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class change_players extends Activity {

    //Initialize TV's to edit
    TextView editPlayer1TV;
    TextView editPlayer2TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_players);

        //GET PLAYER INFO
        Intent intent = getIntent();
        String player1Name = intent.getStringExtra("Player 1");
        String player2Name = intent.getStringExtra("Player 2");
        
        //Get TV's to fill in current names
        editPlayer1TV = (TextView)findViewById(R.id.player1NameTV);
        editPlayer2TV = (TextView)findViewById(R.id.player2NameTV);

        //Set current names
        editPlayer1TV.setText(player1Name);
        editPlayer2TV.setText(player2Name);        
    }
    
    public void onSubmit(View submitbutton){

        //Finish activity and return result
        finish();
        
    }

    public void finish() {
        //get TV player 1 & 2 inputted names
        String newNamePlayer1 = editPlayer1TV.getText().toString();
        String newNamePlayer2 = editPlayer2TV.getText().toString();
        
        Intent data = new Intent();
        data.putExtra("Player 1", newNamePlayer1);
        data.putExtra("Player 2", newNamePlayer2);
        setResult(RESULT_OK, data);
        super.finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_change_players, menu);
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
