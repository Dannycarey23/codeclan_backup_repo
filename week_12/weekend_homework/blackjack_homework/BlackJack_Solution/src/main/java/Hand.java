import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    private int value;


    public Hand() {
        this.cards = new ArrayList<Card>();
        value = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        return this.value;
    }

    public int getNumberOfCards() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.value += card.getValue();
    }



}
