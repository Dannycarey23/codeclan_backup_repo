import coins.Coin;
import coins.CoinType;
import machine.components.coinmanagement.CoinReturn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    Coin onePence;
    Coin twoPence;
    Coin tenPence;
    CoinReturn coinReturn;

    @Before
    public void before(){
        onePence = new Coin(CoinType.ONEPENCE);
        twoPence = new Coin(CoinType.TWOPENCE);
        tenPence = new Coin(CoinType.TENPENCE);
        coinReturn = new CoinReturn();
    }

    @Test
    public void startEmpty(){
        assertEquals(0.0, coinReturn.getValueOfCoins(), 0.01);
    }

    @Test
    public void canGetCoinTotal(){
        coinReturn.addCoin(tenPence);
        coinReturn.addCoin(onePence);
        assertEquals(0.11, coinReturn.getValueOfCoins(), 0.01);
    }
}
