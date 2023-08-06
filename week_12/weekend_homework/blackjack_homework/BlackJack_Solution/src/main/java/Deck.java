import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        generateDeck();
        shuffle();
    }

    public int getNumberOfCards(){
        return cards.size();
    }

    private void generateDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card getCard(){
        return cards.remove(0);
    }
}
