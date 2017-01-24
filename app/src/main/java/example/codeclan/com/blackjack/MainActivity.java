package example.codeclan.com.blackjack;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import example.codeclan.com.blackjack.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Intent intent;
    Intent intent2;
    Intent intent3;
    Button playButton;
    Button optionsButton;
    Button instructionsButton;


    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        playButton= (Button)findViewById(R.id.button_play);
        optionsButton= (Button)findViewById(R.id.button_options);
        instructionsButton= (Button)findViewById(R.id.button_instructions);

        intent = new Intent(MainActivity.this, GameActivity.class);
        intent2 = new Intent(MainActivity.this, InstructionsActivity.class);
        intent3 = new Intent(MainActivity.this, OptionsActivity.class);

        playButton.setOnClickListener(this);
        optionsButton.setOnClickListener(this);
        instructionsButton.setOnClickListener(this);


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
            vibrator.vibrate(10);
            startActivity(intent3);
            Log.d(getClass().toString(), "Options selected");
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case    R.id.button_play:
                vibrator.vibrate(10);
                onPlayButtonPressed(playButton);
                break;
            case    R.id.button_options:
                vibrator.vibrate(10);
                onOptionsButtonPressed(optionsButton);
                break;
            case    R.id.button_instructions:
                vibrator.vibrate(10);
                onInstructionsButtonPressed(instructionsButton);
                break;

        }
    }

}

