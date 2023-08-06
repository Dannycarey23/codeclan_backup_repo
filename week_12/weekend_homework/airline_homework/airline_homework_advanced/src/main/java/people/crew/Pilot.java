package people.crew;

public class Pilot extends CrewMember {

    public String licenseNumber;

    public Pilot(String name, CrewRank rank, String licenseNumber) {
        super(name, rank);
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String fly(){
        return "*Flying Noises*";
    }
}
