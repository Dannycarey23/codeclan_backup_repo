package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlaygroundTest {

    Playground playground;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void visitorCanEnter() {
        Visitor youngVisitor = new Visitor(12, 110, 10.0);
        assertTrue(playground.isAllowed(youngVisitor));
    }

    @Test
    public void visitorCannotEnter() {
        Visitor oldVisitor = new Visitor(16, 140, 10.0);
        assertFalse(playground.isAllowed(oldVisitor));
    }
}
