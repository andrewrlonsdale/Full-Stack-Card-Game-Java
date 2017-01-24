package example.codeclan.com.blackjack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.codeclan.com.blackjack.adapter.CardAdapter;
import example.codeclan.com.blackjack.adapter.ItemDecorator;
import example.codeclan.com.blackjack.model.Game;

/**
 * Created by user on 21/01/2017.
 */
public class GameActivity extends AppCompatActivity {

    private Game game;

    Intent intent3;
    private RecyclerView dealerRecyclerView, playerRecyclerView;
    private CardAdapter dealerCardAdapter, playerCardAdapter;
    private TextView dealerScoreText, playerScoreText, resultText;
    private Button hitButton, standButton, dealButton;
    private LinearLayout dealerScoreLayout, playerScoreLayout, resultLayout, gameOverLayout;



    public GameActivity() {
        game = new Game();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent3 = new Intent(GameActivity.this, OptionsActivity.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initGui();
        initListeners();

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

    private void initGui() {
        dealerRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_dealer);
        playerRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_player);
        setupRecyclerView(dealerRecyclerView);
        setupRecyclerView(playerRecyclerView);

        dealerScoreText = (TextView)findViewById(R.id.txt_dealer_score);
        playerScoreText = (TextView)findViewById(R.id.txt_player_score);

        resultText = (TextView)findViewById(R.id.txt_result);

        hitButton = (Button)findViewById(R.id.btn_hit);
        standButton = (Button)findViewById(R.id.btn_stand);

        dealButton = (Button)findViewById(R.id.btn_deal);

        dealerScoreLayout = (LinearLayout)findViewById(R.id.layout_dealer_score);
        dealerScoreLayout.setVisibility(View.GONE);
        playerScoreLayout = (LinearLayout)findViewById(R.id.layout_player_score);
        playerScoreLayout.setVisibility(View.GONE);
        resultLayout = (LinearLayout)findViewById(R.id.layout_result);
        gameOverLayout = (LinearLayout)findViewById(R.id.layout_gameOver);
    }

    private void initListeners() {
        hitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerHits();
            }
        });

        standButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerStands();
            }
        });


        dealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dealCards();
            }
        });

        resultLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newRound();
            }
        });

        gameOverLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });
    }



    private void startNewGame() {
        game.resetPlayersHands();


        dealerCardAdapter.notifyDataSetChanged();
        playerCardAdapter.notifyDataSetChanged();



        enableDealButtons(true);

        dealerScoreLayout.setVisibility(View.INVISIBLE);
        playerScoreLayout.setVisibility(View.INVISIBLE);
        gameOverLayout.setVisibility(View.INVISIBLE);
    }

    private void dealCards() {
        game.dealAgain();


        dealerCardAdapter = new CardAdapter(game.getDealerHand());
        playerCardAdapter = new CardAdapter(game.getPlayerHand());

        dealerRecyclerView.setAdapter(dealerCardAdapter);
        playerRecyclerView.setAdapter(playerCardAdapter);

        dealerScoreText.setText("?");
        playerScoreText.setText(String.valueOf(game.getPlayerScore()));

        enableActionButtons(true);
        enableDealButtons(false);

        dealerScoreLayout.setVisibility(View.VISIBLE);
        playerScoreLayout.setVisibility(View.VISIBLE);

        if (game.playerHasBlackjack()) {
            enableActionButtons(false);
            playerBlackjack();
        }
    }

    private void newRound() {
        game.resetPlayersHands();


        dealerCardAdapter.notifyDataSetChanged();
        playerCardAdapter.notifyDataSetChanged();

        dealerScoreText.setText("?");
        playerScoreText.setText("");

        enableActionButtons(false);
        enableDealButtons(true);

        dealerScoreLayout.setVisibility(View.INVISIBLE);
        playerScoreLayout.setVisibility(View.INVISIBLE);
        resultLayout.setVisibility(View.INVISIBLE);
    }

    private void playerHits() {
        game.dealPlayerCard();

        playerCardAdapter.notifyDataSetChanged();
        playerScoreText.setText(String.valueOf(game.getPlayerScore()));

        if (game.playerHasBlackjack()) {
            playerStands();
            enableActionButtons(false);
        } else if (game.playerHasBusted()) {
            playerBusts();
            enableActionButtons(false);
        }
    }

    private void playerStands() {
        game.dealerShowHoleCard();

        dealerCardAdapter.notifyDataSetChanged();
        dealerScoreText.setText(String.valueOf(game.getDealerScore()));

        while (game.dealerShouldDrawCard()) {
            game.dealDealerCard();

            dealerCardAdapter.notifyDataSetChanged();
            dealerScoreText.setText(String.valueOf(game.getDealerScore()));

            if (game.dealerHasBusted()) {
                dealerBusts();
                enableActionButtons(false);
                return;
            }
        }

        Game.Outcome outcome = game.getOutcome();
        enableActionButtons(false);

        switch (outcome) {
            case DEALER:
                playerLoses();
                enableActionButtons(false);
                break;
            case PLAYER:
                playerWins();
                enableActionButtons(false);
                break;
            default:
                draw();
                enableActionButtons(false);
        }
    }

    private void playerBlackjack() {
        resultText.setText(R.string.you_got_blackjack);
        showResult();
    }

    private void playerWins() {
        resultText.setText(R.string.you_won);
        showResult();
    }

    private void dealerBusts() {
        resultText.setText(R.string.dealer_busted);
        showResult();
    }

    private void draw() {
        resultText.setText(R.string.draw);
        showResult();
    }

    private void playerBusts() {

        resultText.setText(R.string.you_busted);
        showResult();
    }

    private void playerLoses() {

        resultText.setText(R.string.dealer_won);
        showResult();
    }

    private void showResult() {
        resultLayout.setVisibility(View.VISIBLE);
    }

    private void gameOver() {
        gameOverLayout.setVisibility(View.VISIBLE);
        enableActionButtons(false);
        enableDealButtons(false);
    }

    private void enableDealButtons(boolean enabled) {
        dealButton.setEnabled(enabled);

    }

    private void enableActionButtons(boolean enable) {
        hitButton.setEnabled(enable);
        standButton.setEnabled(enable);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        int overlap;
        if (getResources().getDisplayMetrics().density < 3) {
            overlap = -100;
        } else {
            overlap = -150;
        }
        recyclerView.addItemDecoration(new ItemDecorator(overlap));
    }
}
