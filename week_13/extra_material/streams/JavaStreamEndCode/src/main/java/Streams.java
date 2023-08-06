import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Streams {


    public static void main(String[] args) {

        List<String> myList = new ArrayList<>(Arrays.asList("amanda", "alex", "sandy", "alina", "sky"));

        myList
                .stream()
                .map(String::toUpperCase) // method reference
//                sort list alphabetically
//                .sorted()
                .forEach(result -> System.out.println(result)); //lambda expression
//                 or
//                .forEach(System.out::println);

        Stream.of("amanda", "alex", "sandy", "alina", "sky")
                .findFirst()
                .ifPresent(name -> System.out.println(name.toUpperCase()));

        IntStream.range(1, 5)
                .mapToObj(num -> "number: " + num)
                .forEach(System.out::println);


        Stream.of("E38", "E39", "E40", "E41")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(s -> System.out.println(s));


        Stream.of(38.0, 39.0, 40.0, 41.0)
                .mapToInt(Double::intValue)
                .mapToObj(cohort -> "E" + cohort)
                .forEach(System.out::println);

    }


}
