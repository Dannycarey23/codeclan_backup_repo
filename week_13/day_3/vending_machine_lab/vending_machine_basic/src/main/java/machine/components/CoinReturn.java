package machine.components;

import coins.Coin;

import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin> coins;

    public CoinReturn() {
        coins = new ArrayList<>();
    }

    public void addCoin(Coin coin){
        this.coins.add(coin);
    }

    public double getValueOfCoins(){
        double total = 0.0;
        for (Coin coin : this.coins){
            total += coin.getValue();
        }
        return total;
    }
}
