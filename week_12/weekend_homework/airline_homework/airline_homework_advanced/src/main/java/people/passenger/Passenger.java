package people.passenger;

import people.Person;

public class Passenger extends Person {

    private int bags;
    private String flightNumber;
    private int seatNumber;

    public Passenger(String name, int bags) {
        super(name);
        this.bags = bags;
        this.flightNumber = "";
        this.seatNumber = 0;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
