import java.util.HashMap;

public class Runner {

        public static void main(String[] args) {
            HashMap<String, Country> countryMap = new HashMap<>();

            Country uk = new Country("UK", 64100000, "Europe", "London");
            Country germany = new Country("Germany", 80620000, "Europe", "Berlin");
            Country france = new Country("France", 66030000, "Europe", "Paris");
            Country japan = new Country("Japan", 127300000, "Asia", "Tokyo");

            countryMap.put("UK", uk);
            countryMap.put("Germany", germany);
            countryMap.put("France", france);
            countryMap.put("Japan", japan);

            // Output some values from the HashMap using .get(key) and System.out.println().
            System.out.println(countryMap.get("UK").getName()); // UK
            System.out.println(countryMap.get("Japan").getPopulation()); // 127300000

            // Investigate the use of the .values() and .keySet() methods on HashMap.
            System.out.println(countryMap.keySet()); // [UK, Germany, France, Japan]
            System.out.println(countryMap.values()); // [Country@<hashcode>, Country@<hashcode>, Country@<hashcode>, Country@<hashcode>]
            // Note: The output for values() will be a collection of Country objects' hash codes.

            // Make a function that outputs: In + country + there are + population + people.
            // The capital of + country + is + capital + and it is in + continent +.
            for (Country country : countryMap.values()) {
                System.out.println("In " + country.getName() + " there are " + country.getPopulation() + " people.");
                System.out.println("The capital of " + country.getName() + " is " + country.getCapital() + " and it is in " + country.getContinent() + ".");
            }
        }
    }


