import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) {

        List<Person> people =
                Arrays.asList(
                        new Person("Sandy", 40),
                        new Person("Hannah", 25),
                        new Person("Sky", 35),
                        new Person("Juan", 35));

        //Use streams to get only the names starting with "S"
        List<Person> filtered;
        filtered = people
                .stream()
                .filter(person -> person.getName().startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("names: " + filtered);

        //Get the list into individual values
        for (Person person : filtered){
            System.out.println("names: " + person);
        }


        //Group people by age, using Map interface
        Map<Integer, List<Person>> personsByAge = people
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge
                .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));


        //Get total age for E41 instructors
        int totalAge = people.stream()
                .map(person -> person.getAge())
                .reduce(0, (sum, age )-> sum += age);
        System.out.println(totalAge);


        //Further example
        //Get even numbers to a List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers
                .stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
}
