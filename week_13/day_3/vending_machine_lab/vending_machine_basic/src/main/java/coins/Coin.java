package coins;

public class Coin {
    private CoinType type;

    public Coin(CoinType type) {
        this.type = type;
    }

    public CoinType getType() {
        return type;
    }

    public double getValue(){
        return type.getValue();
    }
}
