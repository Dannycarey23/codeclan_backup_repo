public class Dealer {

    private String name;


    public Dealer(String name) {
        this.name = name;
    }


    public void dealCard(Player player, Deck deck) {
        Card dealtCard = deck.getCard();
        player.addCardToHand(dealtCard);
    }




}
