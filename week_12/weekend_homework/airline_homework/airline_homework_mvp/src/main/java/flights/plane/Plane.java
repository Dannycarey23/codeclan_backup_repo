package flights.plane;

public class Plane {

    private PlaneType type;

    public Plane(PlaneType type) {
        this.type = type;
    }

    public PlaneType getType() {
        return type;
    }

    public int getPlaneCapacity(){
        return this.type.getCapacity();
    }

    public int getTotalWeight(){
        return this.type.getTotalWeight();
    }
}
