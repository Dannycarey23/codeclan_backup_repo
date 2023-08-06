package machine;

import coins.Coin;
import coins.CoinType;
import machine.components.Code;
import machine.components.CoinReturn;
import machine.components.Drawer;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private double credit;
    private CoinReturn coinReturn;

    public VendingMachine(ArrayList<Drawer> drawers, CoinReturn coinReturn) {
        this.drawers = drawers;
        this.credit = 0.0;
        this.coinReturn = coinReturn;
    }

    public void addCoin(Coin coin){
        if (checkCoinValid(coin)) {
            this.credit += coin.getValue();
        } else {
            this.coinReturn.addCoin(coin);
        }
    }

    public double getCredit() {
        return credit;
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public boolean checkCoinValid(Coin coin){
        return coin.getType() != CoinType.ONEPENCE && coin.getType() != CoinType.TWOPENCE ;
    }

    public Product vend(Code code){
        for (Drawer drawer : this.drawers){
            if (code == drawer.getCode() && this.credit >= drawer.getPrice()){
                this.credit = 0.0;
                return drawer.vendProduct();
            }
        }
        return null;
    }
}
