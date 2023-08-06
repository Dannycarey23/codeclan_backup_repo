import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    BusStop busStop;
    Person person;

    @Before
    public void setUp() {
        busStop = new BusStop("Airport");
        person = new Person();
    }

    @Test
    public void canAddToQueue() {
        busStop.add(person);
        assertEquals(1, busStop.queueSize());
    }

    @Test
    public void canRemoveFromQueue() {
        busStop.add(person);
        busStop.removeFromQueue();
        assertEquals(0, busStop.queueSize());
    }
}
