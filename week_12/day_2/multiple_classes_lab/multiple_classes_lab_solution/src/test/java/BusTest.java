import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BusTest {

    Bus bus;
    Person person;
    Person person1;
    Person person2;
    BusStop busStop;

    @Before
    public void setUp() {
        bus = new Bus("Airport", 2);
        person = new Person();
        person1 = new Person();
        person2 = new Person();
        busStop = new BusStop("Airport");
        busStop.add(person);
    }

    @Test
    public void passengerCountStartsAt0() {
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassengers() {
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void cantAddPassengers() {
        bus.addPassenger(person);
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        assertEquals(2, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger() {
        bus.addPassenger(person);
        bus.removePassenger(person);
        assertFalse(bus.getPassengers().contains(person));
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canPickUpFromBusStop() {
        bus.pickUpFromBusStop(busStop);
        assertEquals(1, bus.passengerCount());
        assertEquals(0, busStop.queueSize());
    }

    @Test
    public void cantPickUpFromBusStop() {
        bus.addPassenger(person1);
        bus.addPassenger(person2);
        bus.pickUpFromBusStop(busStop);
        assertEquals(2, bus.passengerCount());
        assertEquals(1, busStop.queueSize());
    }

    @Test
    public void cannotRemoveFromEmptyBusStop(){
        busStop.removeFromQueue();
        bus.pickUpFromBusStop(busStop);
        assertEquals(0, bus.passengerCount());
    }
}
