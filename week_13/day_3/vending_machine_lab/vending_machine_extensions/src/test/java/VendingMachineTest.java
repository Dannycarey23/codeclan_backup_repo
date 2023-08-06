import coins.Coin;
import coins.CoinType;
import machine.VendingMachine;
import machine.components.Code;
import machine.components.coinmanagement.CoinReturn;
import machine.components.Drawer;
import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class VendingMachineTest {

    Coin onePence;
    Coin twoPence;
    Coin tenPence;
    Coin fivePence;
    Coin fiftyPence;
    Drawer drawer;
    CoinReturn coinReturn;
    VendingMachine machine;
    Sweet sweet;

    @Before
    public void before(){
        onePence = new Coin(CoinType.ONEPENCE);
        twoPence = new Coin(CoinType.TWOPENCE);
        tenPence = new Coin(CoinType.TENPENCE);
        fivePence = new Coin(CoinType.FIVEPENCE);
        fiftyPence = new Coin(CoinType.FIFTYPENCE);
        drawer = new Drawer(Code.A1, 0.50);
        sweet = new Sweet("Mars");
        drawer.addItem(sweet);
        ArrayList<Drawer> drawers = new ArrayList<>();
        drawers.add(drawer);
        coinReturn = new CoinReturn();
        machine = new VendingMachine(drawers, coinReturn);
    }

    @Test
    public void canAcceptCoins() {
        machine.addCoin(tenPence);
        assertEquals(0.10, machine.getCredit(), 0.01);
    }

    @Test
    public void cannotAcceptInvalidCoins(){
        machine.addCoin(onePence);
        machine.addCoin(twoPence);
        assertEquals(0.0, machine.getCredit(), 0.01);
        assertEquals(0.03, machine.getCoinReturn().getValueOfCoins(), 0.01);
    }

    @Test
    public void invalidCoinReturns(){
        machine.addCoin(onePence);
        assertEquals(0.01, machine.getCoinReturn().getValueOfCoins(), 0.01);
    }

    @Test
    public void canBuyProduct(){
        machine.addCoin(fiftyPence);
        Sweet product = (Sweet)machine.vend(Code.A1);
        assertEquals("Mars", product.getName());
        assertEquals(0.00, machine.getCredit(), 0.01);
    }


    @Test
    public void notEnoughMoneyReturnsNull(){
        machine.addCoin(tenPence);
        machine.addCoin(tenPence);
        Sweet sweet = (Sweet)machine.vend(Code.A1);
        assertNull(sweet);
    }

    @Test
    public void canGetChange() {
        machine.addCoin(tenPence);
        machine.addCoin(fiftyPence);
        machine.addCoin(fivePence);
        machine.returnChange();
        assertEquals(0.65, machine.getCoinReturn().getValueOfCoins(), 0.01);
    }

    @Test
    public void doesNotVendIfNotExactChangeNeeded(){
        machine.setExactChange(true);
        machine.addCoin(fiftyPence);
        machine.addCoin(fiftyPence);
        Sweet sweet = (Sweet)machine.vend(Code.A1);
        assertNull(sweet);
        assertEquals(1.0, machine.getCoinReturn().getValueOfCoins(), 0.01);
    }

    @Test
    public void canVendExactChangeNeeded(){
        machine.setExactChange(true);
        machine.addCoin(fiftyPence);
        Sweet sweet = (Sweet)machine.vend(Code.A1);
        assertEquals("Mars", sweet.getName());
    }
}
