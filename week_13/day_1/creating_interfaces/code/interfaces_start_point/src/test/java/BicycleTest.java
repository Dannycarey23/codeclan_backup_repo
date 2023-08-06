import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BicycleTest {
    private Bicycle bicycle;

    @Before
    public void before() {
        bicycle = new Bicycle();
    }

    @Test
    public void hasDistanceAtBeginning() {
        assertEquals(0, bicycle.getDistanceTravelled());
    }
}
