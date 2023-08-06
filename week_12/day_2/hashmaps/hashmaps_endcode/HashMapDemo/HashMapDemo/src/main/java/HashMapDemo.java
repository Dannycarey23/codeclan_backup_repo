import java.util.HashMap;

public class HashMapDemo {


    public static void main(String[] args) {
        HashMap<String, String> favouriteFruits = new HashMap<>();

        favouriteFruits.put("Alice", "Apple");
        favouriteFruits.put("Sarah", "Banana");
        favouriteFruits.put("Bob", "Strawberry");

        System.out.println(favouriteFruits.get("Alice"));

        HashMap<String, Integer> ages = new HashMap<String, Integer>();

        ages.put("Alice", 52);
        ages.put("Bob", 24);

        Integer aliceAge = ages.get("Alice");

        String output = "Alice's age is " + aliceAge.toString();
        System.out.println(output);
    }
}
