public class Car {
    private String make;
    private String model;
    private int odometerReading;

    public Car(String make, String model){
        this.make = make;
        this.model = model;
        this.odometerReading = 0;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getOdometerReading() {
        return odometerReading;
    }
}
