package people;

import vehicles.Vehicle;

import java.util.ArrayList;

public class Customer  {

    private String name;
    private double money;
    private ArrayList<Vehicle> vehicles;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public int getVehicleCount(){
        return this.vehicles.size();
    }

    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public void buyVehicle(Vehicle vehicle){
        addVehicle(vehicle);
        this.money -= vehicle.getPrice();
    }
}
