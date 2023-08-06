package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void hasRating() {
        assertEquals(2, tobaccoStall.getRating());
    }

    @Test
    public void visitorAllowed() {
        Visitor olderVisitor = new Visitor(18, 170, 20.0);
        assertTrue(tobaccoStall.isAllowed(olderVisitor));
    }

    @Test
    public void visitorNotAllowed() {
        Visitor youngVisitor = new Visitor(16, 140, 10.0);
        assertFalse(tobaccoStall.isAllowed(youngVisitor));
    }
}
