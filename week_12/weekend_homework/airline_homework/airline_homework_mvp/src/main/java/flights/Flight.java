package flights;

import flights.plane.Plane;
import people.crew.Pilot;
import people.crew.CabinCrewMember;
import people.passenger.Passenger;

import java.util.ArrayList;

public class Flight {

    private ArrayList<Pilot> pilots;
    private ArrayList<CabinCrewMember> crew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private AirportID destinationAirport;
    private AirportID departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, AirportID destinationAirport, AirportID departureAirport, String departureTime){
        this.pilots = new ArrayList<Pilot>();
        this.crew = new ArrayList<CabinCrewMember>();
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public int getPilots() {
        return pilots.size();
    }

    public int getCrew() {
        return crew.size();
    }

    public int getPassengers() {
        return passengers.size();
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestinationAirport() {
        return destinationAirport.getCode();
    }

    public String getDepartureAirport() {
        return departureAirport.getCode();
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int remainingSeats(){
        return (this.plane.getPlaneCapacity() - this.getPassengers());
    }

    public void addPilot(Pilot pilot){
        this.pilots.add(pilot);
    }

    public void addCabinCrew(CabinCrewMember cabinCrew){
        this.crew.add(cabinCrew);
    }

    public void addPassenger(Passenger passenger){
        if (this.plane.getPlaneCapacity() > this.getPassengers()){
            this.passengers.add(passenger);
        }
    }
}
