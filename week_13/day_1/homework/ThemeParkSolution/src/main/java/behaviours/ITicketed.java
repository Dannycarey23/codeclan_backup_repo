package behaviours;

import people.Visitor;

public interface ITicketed {

    double defaultPrice();

    double priceFor(Visitor visitor);


}
