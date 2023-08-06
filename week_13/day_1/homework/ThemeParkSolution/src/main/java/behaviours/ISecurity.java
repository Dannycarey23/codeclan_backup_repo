package behaviours;

import people.Visitor;

public interface ISecurity {

    boolean isAllowed(Visitor visitor);
}
