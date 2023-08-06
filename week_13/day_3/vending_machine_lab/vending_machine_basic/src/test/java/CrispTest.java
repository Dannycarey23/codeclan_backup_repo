import org.junit.Before;
import org.junit.Test;
import products.Crisps;

import static org.junit.Assert.assertEquals;

public class CrispTest {

    Crisps crisps;

    @Before
    public void before(){
        crisps = new Crisps("Walkers", "Cheese and Onion");
    }

    @Test
    public void hasName() {
        assertEquals("Walkers", crisps.getName());
    }


    @Test
    public void hasFlavour(){
        assertEquals("Cheese and Onion", crisps.getFlavour());
    }
}
