import org.junit.Before;
import org.junit.Test;
import products.Crisps;
import products.Drink;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink drink;

    @Before
    public void before(){
        drink = new Drink("Cola");
    }

    @Test
    public void hasName() {
        assertEquals("Cola", drink.getName());
    }


}
