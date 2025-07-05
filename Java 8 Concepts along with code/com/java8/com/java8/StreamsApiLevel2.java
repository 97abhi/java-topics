

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsApiLevel2 {

    public static <T> Predicate<T> not(Predicate<T> p) {
        return p.negate();
    }
public static void main(String[] args) {
    List<String> names = Arrays.asList("John", "", null, "Alice", "Bob", "", null, "Charlie");

// ➔ Filter out null and empty strings using Stream API.
    System.out.println(names.stream().filter(x -> x != null && !x.equals("")).collect(Collectors.toList()));

    List<String> fruits = Arrays.asList("Apple", "", null, "Banana", " ", "Mango", null, "Grapes", "");

        System.out.println(fruits.stream().filter(fruit -> fruit != null && !fruit.equals("") && !fruit.equals(" ")).collect(Collectors.toList()));

        System.out.println(
    fruits.stream()
          .filter(fruit -> fruit != null && !fruit.trim().isEmpty())
          .collect(Collectors.toList()));

}   
}
