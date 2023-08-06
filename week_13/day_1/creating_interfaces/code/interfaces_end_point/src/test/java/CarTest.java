import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    private Car car;

    @Before
    public void before() {
        car = new Car("Ford", "Escort");
    }

    @Test
    public void hasMake() {
        assertEquals("Ford", car.getMake());
    }

    @Test
    public void hasModel() {
        assertEquals("Escort", car.getModel());
    }

    @Test
    public void odomoterReadingStartsAtZero() {
        assertEquals(0, car.getOdometerReading());
    }

    @Test
    public void canMove() {
        car.move(10);
        assertEquals(10, car.getOdometerReading());
    }

    @Test
    public void canStart() {
        assertEquals("Switch on the ignition", car.start());
    }

    @Test
    public void canStop() {
        assertEquals("Ease off the accelerator, apply the brake", car.stop());
    }
}
