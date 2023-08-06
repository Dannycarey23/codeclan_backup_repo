public class Car implements Convert {
    private String name;
    private int age;

    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String convert() {
        return "Car data";
    }
}
