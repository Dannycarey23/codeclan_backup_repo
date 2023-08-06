import java.util.ArrayList;

public class Bus {

    private String destination;
    private int capacity;
    private ArrayList<Person> passengers;

    public Bus(String destination, int capacity) {
        this.destination = destination;
        this.capacity = capacity;
        this.passengers = new ArrayList<Person>();
    }

    public ArrayList<Person> getPassengers() {
        return passengers;
    }

    public int passengerCount() {
        return this.passengers.size();
    }


    public void addPassenger(Person person) {
        if (this.passengerCount() < this.capacity) {
            this.passengers.add(person);
        }
    }


    public void removePassenger(Person person) {
        this.passengers.remove(person);
    }

    public void pickUpFromBusStop(BusStop busStop) {
        if(this.passengerCount() < this.capacity && busStop.queueSize() > 0){
            Person personRemoved = busStop.removeFromQueue();
            this.addPassenger(personRemoved);
        }
    }
}
