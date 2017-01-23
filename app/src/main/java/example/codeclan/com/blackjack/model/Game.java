package example.codeclan.com.blackjack.model;

/**
 * Created by user on 21/01/2017.
 */

public class Game {

    private Dealer dealer;
    private Player player;
    private Deck deck;

    public enum Outcome {
        PLAYER, DEALER, DRAW
    }

    public Game() {
        deck = new Deck();
        dealer = new Dealer(deck.createStartHand());
        player = new Player(deck.createStartHand());
    }

    public void dealAgain() {
        deck = new Deck();
        dealer.setHand(deck.createStartHand());
        player.setHand(deck.createStartHand());
    }

    public Hand getDealerHand() {
        return dealer.getHand();
    }

    public Hand getPlayerHand() {
        return player.getHand();
    }

    public int getDealerScore() {
        return dealer.getHand().getScore();
    }

    public int getPlayerScore() {
        return player.getHand().getScore();
    }

    public boolean playerHasBlackjack() {
        return player.hasBlackjack();
    }

    public boolean dealerHasBusted() {
        return dealer.hasBusted();
    }

    public boolean playerHasBusted() {
        return player.hasBusted();
    }

    public boolean dealerShouldDrawCard() {
        return dealer.shouldDrawCard();
    }

    public void dealerShowHoleCard() {
        dealer.showHoleCard();
    }

    public void dealDealerCard() {
        dealer.dealCard(deck.getRandomCard());
    }

    public void dealPlayerCard() {
        player.dealCard(deck.getRandomCard());
    }

    public void resetPlayersHands() {
        dealer.resetHand();
        player.resetHand();
    }


    public Outcome getOutcome() {
        int playerScore = player.getHand().getScore();
        int dealerScore = dealer.getHand().getScore();

        if (playerScore == dealerScore) {
            return Outcome.DRAW;
        }

        return (playerScore > dealerScore) ? Outcome.PLAYER : Outcome.DEALER;
    }
}
