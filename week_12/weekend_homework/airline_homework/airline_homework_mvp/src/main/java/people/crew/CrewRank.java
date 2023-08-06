package people.crew;

public enum CrewRank {

    CAPTAIN("Captain"),
    FIRSTOFFCER("First Officer"),
    LEADATTENDANT("Lead Attendant"),
    FLIGHTATTENDANT("Flight Attendant");

    private final String rank;

    CrewRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

}
