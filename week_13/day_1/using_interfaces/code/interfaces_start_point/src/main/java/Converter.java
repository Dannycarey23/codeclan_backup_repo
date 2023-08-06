public class Converter {
    public static String process(Vehicle vehicle){
        return vehicle.convert();
    }
    public static String process(Convert convert){
        return convert.convert();
    }
}
