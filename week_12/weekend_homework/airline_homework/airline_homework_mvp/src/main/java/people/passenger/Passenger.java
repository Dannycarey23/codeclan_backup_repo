package people.passenger;

import people.Person;

public class Passenger extends Person {

    private int bags;

    public Passenger(String name, int bags) {
        super(name);
        this.bags = bags;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }
}
