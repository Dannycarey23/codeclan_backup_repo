import flights.AirportID;
import flights.Flight;
import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrewMember;
import people.crew.CrewRank;
import people.crew.Pilot;
import people.passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Pilot pilot;
    CabinCrewMember cabinCrew;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("Huey", 3);
        passenger2 = new Passenger("Louis", 2);
        passenger3 = new Passenger("Dewey", 1);
        cabinCrew = new CabinCrewMember("Flores", CrewRank.LEADATTENDANT);
        pilot = new Pilot("Irena", CrewRank.CAPTAIN, "SD43TR");
        plane = new Plane(PlaneType.DINKYPLANE);
        flight = new Flight(plane, "D1NK3Y", AirportID.BORABORA, AirportID.SHETLAND, "2021, Feb, 15, 1015");
    }

    @Test
    public void pilotBeginsEmpty() {
        assertEquals(0, flight.getPilots());
    }

    @Test
    public void canAddPilot() {
        flight.addPilot(pilot);
        assertEquals(1, flight.getPilots());
    }

    @Test
    public void crewBeginsEmpty() {
        assertEquals(0, flight.getCrew());
    }

    @Test
    public void canAddCrew() {
        flight.addCabinCrew(cabinCrew);
        assertEquals(1, flight.getCrew());
    }

    @Test
    public void passengersBeginsEmpty() {
        assertEquals(0, flight.getPassengers());
    }

    @Test
    public void canAddPassengers() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getPassengers());
    }

    @Test
    public void cannotAddPassengers() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(2, flight.getPassengers());
    }

    @Test
    public void canGetPlane() {
        Plane planeInfo = flight.getPlane();
        assertEquals("DINKYPLANE", planeInfo.getType().toString());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("D1NK3Y", flight.getFlightNumber());
    }

    @Test
    public void canSetFLightNumber() {
        flight.setFlightNumber("4LT");
        assertEquals("4LT", flight.getFlightNumber());
    }

    @Test
    public void canGetDestination() {
        assertEquals("BOB", flight.getDestinationAirport());
    }

    @Test
    public void canGetDepartureAirport() {
        assertEquals("LWK", flight.getDepartureAirport());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("2021, Feb, 15, 1015", flight.getDepartureTime());
    }

    @Test
    public void canSetDepartureTime() {
        flight.setDepartureTime("2022, Feb, 15, 1015");
        assertEquals("2022, Feb, 15, 1015", flight.getDepartureTime());
    }

    @Test
    public void canReturnRemainingSeats() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.remainingSeats());
    }

}
