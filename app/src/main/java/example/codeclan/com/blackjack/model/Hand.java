package example.codeclan.com.blackjack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23/01/2017.
 */

public class Hand {

    public static final int LIMIT = 21;

    private List<Card> cards;
    private int sum = 0;

    public Hand(List<Card> cards) {
        this.cards = cards;

    }

}
