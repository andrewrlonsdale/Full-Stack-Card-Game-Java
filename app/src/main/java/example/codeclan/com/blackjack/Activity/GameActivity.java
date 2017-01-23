package example.codeclan.com.blackjack.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.codeclan.com.blackjack.R;
import example.codeclan.com.blackjack.model.Game;

/**
 * Created by user on 21/01/2017.
 */
public class GameActivity extends AppCompatActivity {

    private Game game;
    Intent intent3;



    public GameActivity() {
        game = new Game();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent3 = new Intent(GameActivity.this, OptionsActivity.class);


        Log.d(getClass().toString(), "on create called");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_option) {
            startActivity(intent3);
            Log.d(getClass().toString(), "Options selected");
        }
        return super.onOptionsItemSelected(item);
    }
}
