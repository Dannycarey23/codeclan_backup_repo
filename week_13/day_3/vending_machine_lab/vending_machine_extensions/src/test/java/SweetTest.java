import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class SweetTest {

    Sweet sweet;

    @Before
    public void before(){
        sweet = new Sweet("Mars");
    }

    @Test
    public void hasName() {
        assertEquals("Mars", sweet.getName());
    }


}
