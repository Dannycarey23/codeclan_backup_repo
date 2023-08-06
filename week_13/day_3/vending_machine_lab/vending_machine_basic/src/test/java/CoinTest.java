import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin coin;

    @Before
    public void before() {
        coin = new Coin(CoinType.TENPENCE);
    }

    @Test
    public void hasType(){
        assertEquals(CoinType.TENPENCE, coin.getType());
    }

    @Test
    public void hasValue(){
        assertEquals(0.10, coin.getValue(),0.01);
    }
}
