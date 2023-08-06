package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor tallVisitor;
    Visitor shortVisitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        tallVisitor = new Visitor(13, 200, 10.0);
        shortVisitor = new Visitor(15, 140, 10.0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.1);
    }

    @Test
    public void visitorAllowed() {
        assertTrue(rollerCoaster.isAllowed(tallVisitor));
    }

    @Test
    public void visitorNotAllowedHeight() {
        assertFalse(rollerCoaster.isAllowed(shortVisitor));
    }

    @Test
    public void visitorNotAllowedAge() {
        Visitor youngVisitor = new Visitor(11, 160, 10.0);
        assertFalse(rollerCoaster.isAllowed(youngVisitor));
    }

    @Test
    public void chargeDefault() {
        assertEquals(8.40, rollerCoaster.priceFor(shortVisitor), 0.1);
    }

    @Test
    public void tallChargeDouble() {
        assertEquals(16.80, rollerCoaster.priceFor(tallVisitor), 0.11);
    }
}
