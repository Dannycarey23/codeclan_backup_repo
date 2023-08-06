import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterBottleTest {
    private WaterBottle waterBottle;

    @Before
    public void setUp() {
        waterBottle = new WaterBottle();
    }

    @Test
    public void hasCorrectVolume() {
      assertEquals(100, waterBottle.getVolume());
    }

    @Test
    public void drinkRemoves10Volume() {
        waterBottle.drink();
        assertEquals(90, waterBottle.getVolume());
    }

    @Test
    public void emptySetsVolumeTo0() {
        waterBottle.empty();
        assertEquals(0, waterBottle.getVolume());
    }

    @Test
    public void fillSetsVolumeTo100() {
        waterBottle.empty();
        waterBottle.fill();
        assertEquals(100, waterBottle.getVolume());
    }
}
