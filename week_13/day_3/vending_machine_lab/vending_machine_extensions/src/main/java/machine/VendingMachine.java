package machine;

import coins.Coin;
import coins.CoinType;
import machine.components.Code;
import machine.components.coinmanagement.CoinReturn;
import machine.components.Drawer;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private double credit;
    private CoinReturn coinReturn;
    private boolean exactChange;

    public VendingMachine(ArrayList<Drawer> drawers, CoinReturn coinReturn) {
        this.drawers = drawers;
        this.credit = 0.0;
        this.coinReturn = coinReturn;
        this.exactChange = false;
    }

    public void addCoin(Coin coin) {
        if (checkCoinValid(coin)) {
            this.credit += coin.getValue();
        } else {
            this.coinReturn.addCoin(coin);
        }
    }

    public void setExactChange(boolean exactChange) {
        this.exactChange = exactChange;
    }

    public double getCredit() {
        return credit;
    }

    public CoinReturn getCoinReturn() {
        return coinReturn;
    }

    public boolean checkCoinValid(Coin coin) {
        return coin.getType() != CoinType.ONEPENCE && coin.getType() != CoinType.TWOPENCE;
    }

    public Drawer getDrawer(Code code) {
        for (Drawer drawer : this.drawers) {
            if (drawer.getCode() == code) {
                return drawer;
            }
        }
        return null;
    }

    public Product vend(Code code) {
        Drawer drawer = getDrawer(code);
        if (exactChange && drawer.getPrice() != credit) {
            returnChange();
        } else if (code == drawer.getCode() && this.credit >= drawer.getPrice()) {
            this.credit -= drawer.getPrice();
            returnChange();
            return drawer.vendProduct();
        }

        return null;
    }

    public void returnChange() {
        if (this.credit >= 0) {
            while (credit > 1.00) {
                this.coinReturn.addCoin(new Coin(CoinType.ONEPOUND));
                this.credit -= 1.0;
            }
            while (credit >= 0.5) {
                this.coinReturn.addCoin(new Coin(CoinType.FIFTYPENCE));
                this.credit -= 0.5;
            }

            while (credit >= 0.2) {
                this.coinReturn.addCoin(new Coin(CoinType.TWENTYPENCE));
                this.credit -= 0.2;
            }

            while (credit >= 0.1) {
                this.coinReturn.addCoin(new Coin(CoinType.TENPENCE));
                this.credit -= 0.1;
            }

            while (credit >= 0.05) {
                this.coinReturn.addCoin(new Coin(CoinType.FIVEPENCE));
                this.credit -= 0.05;
            }
        }
    }
}
