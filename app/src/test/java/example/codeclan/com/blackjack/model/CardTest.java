package example.codeclan.com.blackjack.model;

import org.junit.Before;
import org.junit.Test;

import static example.codeclan.com.blackjack.model.Suit.HEARTS;
import static example.codeclan.com.blackjack.model.Value.ACE;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 25/01/2017.
 */
public class CardTest {

    Card card;
    Value value;
    Suit suit;

    @Before
    public void setup() {
            card = new Card(HEARTS,ACE);
        }

    
    @Test
    public void getSuit() throws Exception {
        assertEquals(HEARTS, card.getSuit());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals(ACE, card.getValue());
    }

    @Test
    public void isVisible() throws Exception {
        assertEquals(false, card.isVisible());
    }


}