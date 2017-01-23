package example.codeclan.com.blackjack.model;

/**
 * Created by user on 23/01/2017.
 */

public class Dealer extends User {

    public Dealer(Hand hand) {
        super(hand);
    }
    public boolean shouldDrawCard() {
        return getHand().getScore() <= 16;
    }



}
