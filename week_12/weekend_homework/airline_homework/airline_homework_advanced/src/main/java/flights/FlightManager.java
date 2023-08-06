package flights;

import people.passenger.Passenger;

public class FlightManager {

    Flight flight;
    int flightCargoData;

    public FlightManager(Flight flight) {
        this.flight = flight;
        this.flightCargoData = flight.getPlane().getTotalWeight();
    }

    public int getFlightCargoData() {
        return flightCargoData;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public int getBaggageCapacity(){
        return (this.flightCargoData / 2);
    }

    public int getWeightAllowancePerCustomer(){
        int passengerCount = this.flight.getPassengers();
        System.out.println(passengerCount);
        return (this.getBaggageCapacity() / passengerCount);
    }

    public int getTotalBaggageWeight(){
        int totalItemsOfLuggage = 0;
        for (Passenger passenger : this.flight.getPassengerManifest()){
            totalItemsOfLuggage += passenger.getBags();
        }
        return (totalItemsOfLuggage * this.flight.getWeightPerBag());
    }

    public int getRemainingCargoCapacity(){
        return (this.getBaggageCapacity() - this.getTotalBaggageWeight());
    }
}
