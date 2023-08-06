import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {

    Hand hand;
    Card card;
    Card card2;
    @Before
    public void setup(){
        hand = new Hand();
        card = new Card(Suit.CLUBS, Rank.JACK);
        card2 = new Card(Suit.DIAMONDS, Rank.ACE);
    }

    @Test
    public void valueIs0Initially(){
        assertEquals(0, hand.getHandValue());
    }

    @Test
    public void cardIsAdded(){
        hand.addCard(card);
        hand.addCard(card2);
        assertEquals(2, hand.getCards().size());
    }

    @Test
    public void handHasValue(){
        hand.addCard(card);
        hand.addCard(card2);
        assertEquals(11, hand.getHandValue());
    }

}
