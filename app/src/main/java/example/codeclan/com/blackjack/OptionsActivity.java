package example.codeclan.com.blackjack;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


import static example.codeclan.com.blackjack.R.color.color_blue;
import static example.codeclan.com.blackjack.R.color.color_green;
import static example.codeclan.com.blackjack.R.color.color_red;

/**
 * Created by user on 21/01/2017.
 */
public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent3;
    RadioButton green, red, blue, deck1, deck2, deck3;
    private Button vibrateButton;

    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        vibrateButton = (Button)findViewById(R.id.vibrate);
        green = (RadioButton)findViewById(R.id.radioButton1);
        red = (RadioButton)findViewById(R.id.radioButton2);
        blue = (RadioButton)findViewById(R.id.radioButton3);
        deck1 = (RadioButton)findViewById(R.id.radioButton4);
        deck2 = (RadioButton)findViewById(R.id.radioButton5);
        deck3 = (RadioButton)findViewById(R.id.radioButton6);

        vibrateButton.setOnClickListener(this);
        green.setOnClickListener(this);
        red.setOnClickListener(this);
        blue.setOnClickListener(this);
        deck3.setOnClickListener(this);
        deck2.setOnClickListener(this);
        deck1.setOnClickListener(this);



        intent3 = new Intent(OptionsActivity.this, OptionsActivity.class);

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

//    public void onGreenButtonClick(RadioButton button) {
//        Log.d("PersistenceExample:", "green Button Clicked!");
//        if (button.getItemId() == R.id.radioButton1) {
//            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
//        }
//    }

    public void onRedButtonClick(View view) {
        Log.d("PersistenceExample:", "red Button Clicked!");
        getResources().getColor(color_red);
    }

    public void onBlueButtonClick(View view) {
        Log.d("PersistenceExample:", "blue Button Clicked!");
        getResources().getColor(color_blue);
    }

    public void onDeck1ButtonClick(View view) {
        Log.d("PersistenceExample:", "blue Button Clicked!");
        getResources().getColor(color_blue);
    }

    public void onDeck2ButtonClick(View view) {
        Log.d("PersistenceExample:", "blue Button Clicked!");
        getResources().getColor(color_blue);
    }

    public void onDeck3ButtonClick(View view) {
        Log.d("PersistenceExample:", "blue Button Clicked!");
        getResources().getColor(color_blue);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case    R.id.vibrate:
                vibrator.vibrate(1000);
                break;
        }
    }

}
