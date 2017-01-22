package example.codeclan.com.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by user on 21/01/2017.
 */
public class InstructionsActivity extends AppCompatActivity {

    Intent intent3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        intent3 = new Intent(InstructionsActivity.this, OptionsActivity.class);

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
