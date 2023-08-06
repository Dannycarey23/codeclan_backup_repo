package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice() {
        return 2.80;
    }

    public double priceFor(Visitor visitor) {
        double modifier = visitor.getAge() < 12 ? 0.5 : 1.0;
        return defaultPrice() * modifier;
    }
}
