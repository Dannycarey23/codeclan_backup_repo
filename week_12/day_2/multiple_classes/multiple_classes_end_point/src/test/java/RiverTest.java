import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RiverTest {

    River river;
    Salmon salmon;

    @Before
    public void setUp() {
        river = new River();
        salmon = new Salmon();
    }

    @Test
    public void canAddSalmonToRiver() {
        river.add(salmon);
        assertEquals(1, river.getFishCount());
    }

    @Test
    public void canRemoveSalmonFromRiver() {
        river.add(salmon);
        river.removeFish();
        assertEquals(0, river.getFishCount());
    }
}
