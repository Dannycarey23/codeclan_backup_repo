import flights.AirportID;
import flights.FlightManager;
import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;
import flights.Flight;
import people.passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before(){
        passenger1 = new Passenger("Mr Blobby", 15);
        passenger2 = new Passenger("Noel Funhouse", 1);
        Plane plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "B031NG", AirportID.MAGALUF, AirportID.GLASGOW, "2021/02/15 10:15");
        flightManager = new FlightManager(flight);
    }

    @Test
    public void canGetFlightCargoData(){
        assertEquals(800, flightManager.getFlightCargoData());
    }

    @Test
    public void canGetFlight(){
        Flight currentFlight = flightManager.getFlight();
        assertEquals("B031NG", currentFlight.getFlightNumber());
    }

    @Test
    public void canGetBaggageCapacity(){
        assertEquals(400, flightManager.getBaggageCapacity());
    }

    @Test
    public void canGetWeightAllowancePerCustomer(){
        Flight currentFlight = flightManager.getFlight();
        currentFlight.addPassenger(passenger1);
        currentFlight.addPassenger(passenger2);
        assertEquals(200, flightManager.getWeightAllowancePerCustomer());
    }

    @Test
    public void canGetTotalBaggageWeight(){
        Flight currentFlight = flightManager.getFlight();
        currentFlight.addPassenger(passenger1);
        currentFlight.addPassenger(passenger2);
        assertEquals(320, flightManager.getTotalBaggageWeight());
    }

    @Test
    public void canGetRemainingCargoCapacity(){
        Flight currentFlight = flightManager.getFlight();
        currentFlight.addPassenger(passenger1);
        currentFlight.addPassenger(passenger2);
        assertEquals(80, flightManager.getRemainingCargoCapacity());
    }
}
