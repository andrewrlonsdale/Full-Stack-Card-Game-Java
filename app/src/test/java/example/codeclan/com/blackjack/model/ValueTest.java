package example.codeclan.com.blackjack.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 25/01/2017.
 */
public class ValueTest {

    Value value;

    @Before
    public void before(){
        value =  Value.ACE;
    }

    @Test
    public void getValue() throws Exception {
    assertEquals(1, value.getValue());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("A", value.getName());
    }

    @Test
    public void getPoints() throws Exception {
        assertEquals(1, value.getPoints());
    }

}