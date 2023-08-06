package people.crew;

public class CabinCrewMember extends CrewMember{

    public CabinCrewMember(String name, CrewRank rank) {
        super(name, rank);
    }

    public String giveAnnouncement(String announcement){
        return "Attention all passengers: " + announcement;
    }

    public String indicateExits(){
        return "The exits are located here, here, and here.";
    }
}
