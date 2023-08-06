package people.crew;

import people.Person;

public class CrewMember extends Person {

    CrewRank rank;

    public CrewMember(String name, CrewRank rank) {
        super(name);
        this.rank = rank;
    }

    public String getRank() {
        return rank.getRank();
    }
}
