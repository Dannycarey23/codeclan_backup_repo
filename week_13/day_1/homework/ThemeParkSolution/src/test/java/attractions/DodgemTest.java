package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import people.VisitorTest;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }

    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasDefaultprice(){
        assertEquals(2.80, dodgems.defaultPrice(), 0.1);
    }

    @Test
    public void chargeNormalOver12() {
        Visitor normalPrice = new Visitor(12, 100, 20.0);
        assertEquals(2.80, dodgems.priceFor(normalPrice), 0.1);
    }

    @Test
    public void chargeHalfUnder12() {
        Visitor halfPrice = new Visitor(10, 80, 20.0);
        assertEquals(1.40, dodgems.priceFor(halfPrice), 0.1);
    }
}
