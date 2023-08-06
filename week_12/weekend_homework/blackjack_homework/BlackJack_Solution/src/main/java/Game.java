import java.util.ArrayList;

public class Game {
    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;

    public Game(Deck deck, ArrayList<Player> players, Dealer dealer) {
        this.deck = deck;
        this.dealer = dealer;
        this.players = players;
    }

    public void startGame() {
        for (Player player : players){
            for (int i = 0; i < players.size(); i++){
                dealer.dealCard(player, this.deck);
            }
        }
    }

    public void twist(Player player){
        if(!isBust(player)) {
            dealer.dealCard(player, this.deck);
        }
    }

    private boolean isBust(Player player){
        return player.getHandValue() > 21;
    }

    public Player checkWinner(){
       Player winner = this.players.get(0);
        for (Player player : this.players){
            if (player.getHandValue() > winner.getHandValue() && !isBust(player)){
                winner = player;
            }
        }
        return winner;
    }
}
