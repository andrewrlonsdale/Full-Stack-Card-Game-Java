package example.codeclan.com.blackjack.model;

/**
 * Created by user on 23/01/2017.
 */

public abstract class User {

    private Hand hand;


    public User(Hand hand) {
        setHand(hand);
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;

    }

}
