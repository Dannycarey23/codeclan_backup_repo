public
class Car implements IMove, IStart, IStop {
    private String make;
    private String model;
    private int odometerReading;

    public Car(String make, String model){
        this.make = make;
        this.model = model;
        this.odometerReading = 0;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getOdometerReading() {
        return this.odometerReading;
    }

    public void move(int distance) {
        this.odometerReading += distance;
    }

    public String start(){
        return "Switch on the ignition";
    }

    public String stop () {
        return "Ease off the accelerator, apply the brake";
    }
}
