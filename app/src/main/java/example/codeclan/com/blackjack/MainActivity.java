package example.codeclan.com.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import example.codeclan.com.blackjack.R;


public class MainActivity extends AppCompatActivity {

    Intent intent;
    Intent intent2;
    Intent intent3;
    Button playButton;
    Button optionsButton;
    Button instructionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton= (Button)findViewById(R.id.button_play);
        optionsButton= (Button)findViewById(R.id.button_options);
        instructionsButton= (Button)findViewById(R.id.button_instructions);

        intent = new Intent(MainActivity.this, GameActivity.class);
        intent2 = new Intent(MainActivity.this, InstructionsActivity.class);
        intent3 = new Intent(MainActivity.this, OptionsActivity.class);


        Log.d(getClass().toString(), "on create called");

    }


    public void onPlayButtonPressed(View button){
        Log.d(getClass().toString(),"Play button pressed");
        startActivity(intent);
    }

    public void onInstructionsButtonPressed(View button){
        Log.d(getClass().toString(),"Instructions button pressed");
        startActivity(intent2);
    }

    public void onOptionsButtonPressed(View button){
        Log.d(getClass().toString(),"Options button pressed");
        startActivity(intent3);
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
