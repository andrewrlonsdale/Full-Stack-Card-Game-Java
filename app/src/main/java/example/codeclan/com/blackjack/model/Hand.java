package example.codeclan.com.blackjack.model;

import java.util.ArrayList;
import java.util.List;

import example.codeclan.com.blackjack.utils.Scorer;
/**
 * Created by user on 23/01/2017.
 */


public class Hand {
    public static final int LIMIT = 21;

    private List<Card> cards;
    private int sum = 0;

    public Hand(List<Card> cards) {
        this.cards = cards;
        calculateSum();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        return sum;
    }

    public boolean isBlackjackHand() {
        return sum == LIMIT;
    }

    public boolean isBusted() {
        return sum > LIMIT;
    }

    public void addCard(Card card) {
        cards.add(card);
        calculateSum();
    }

    private void calculateSum() {
        sum = Scorer.getInstance().calculate(cards);
    }

    public void reset() {
        this.cards = new ArrayList<>();
        this.sum = 0;
    }
}

