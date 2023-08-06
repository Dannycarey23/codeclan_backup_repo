package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {


    public Playground(String name, int rating) {
        super(name, rating);
    }


    public boolean isAllowed(Visitor visitor) {
        return visitor.getAge() <= 15;
    }
}
