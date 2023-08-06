import org.junit.Before;
import org.junit.Test;
import people.passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Marcus", 2);
    }

    @Test
    public void canGetName(){
        assertEquals("Marcus", passenger.getName());
    }

    @Test
    public void canSetName(){
        passenger.setName("Markus");
        assertEquals("Markus", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags(){
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void canSetNumberOfBags(){
        passenger.setBags(3);
        assertEquals(3, passenger.getBags());
    }

    @Test
    public void flightNumberBeginsEmpty(){
        assertEquals("", passenger.getFlightNumber());
    }

    @Test
    public void canSetFlightNumber(){
        passenger.setFlightNumber("T3ST");
        assertEquals("T3ST", passenger.getFlightNumber());
    }

    @Test
    public void seatNumberBeginsAtZero(){
        assertEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void canSetSeatNumber(){
        passenger.setSeatNumber(5);
        assertEquals(5, passenger.getSeatNumber());
    }
}

