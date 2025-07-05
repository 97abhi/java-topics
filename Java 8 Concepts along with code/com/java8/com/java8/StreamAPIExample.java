

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Source (List, Set, Array)
      ↓
Intermediate Operations (filter, map, sorted, etc.)
      ↓
Terminal Operation (collect, forEach, reduce, etc.)
 */


 /*
  * Method          | What it does                  | Example usage
 filter(Predicate)  | Filters elements              | filter(x -> x > 5)
 map(Function)      | Transforms each element       | map(x -> x*x)
 flatMap(Function)  | Flattens nested collections   | flatMap(List::stream)
 distinct()         | Removes duplicates            | distinct()
 sorted()           | Sorts elements                | sorted()
 limit(n)           | Limits to n elements          | limit(5)
 skip(n)            | Skips n elements              | skip(3)
  */

  // 1. filter number out of list which is greater than 5 and square each number
  // 2. 
public class StreamAPIExample {
 public static void main(String[] args) {
     List<Integer> numbers = Arrays.asList(2, 34, 5, 7, 8, 9);

     numbers.stream().filter(n -> n > 5).map(n -> n * n).forEach(System.out::println);

     List<String> names = Arrays.asList("john", "JANE", "jack", "doe", "DANIEL");

     /*
      * 
      * Using Stream API, do the following:
      * Filter names that start with lowercase "j".
      * Convert all filtered names to UPPERCASE.
      * Collect them into a List.
      * Print the final list.
      */

     List<String> res = names.stream().filter((name) -> name.startsWith("j")).map(String::toUpperCase)
             .collect(Collectors.toList());

     res.stream().forEach(System.out::println);

     List<List<String>> listOfLists = Arrays.asList(
             Arrays.asList("a", "b"),
             Arrays.asList("c", "d"));

     List<String> flatList = listOfLists.stream()
             .flatMap(List::stream)
             .collect(Collectors.toList());

     System.out.println(flatList); // Output: [a, b, c, d]

     List<Integer> numbersDistinct = Arrays.asList(1, 2, 2, 3, 3, 4);

     List<Integer> unique = numbersDistinct.stream()
             .distinct()
             .collect(Collectors.toList());

     System.out.println(unique);

     System.out.println(numbers.stream().sorted().collect(Collectors.toList()));

     System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

     System.out.println(numbers.stream().limit(3).collect(Collectors.toList()));

     System.out.println(numbers.stream().skip(3).collect(Collectors.toList()));

     List<List<String>> classes = Arrays.asList(
        Arrays.asList("Alice", "Bob"),
        Arrays.asList("Ankit", "Brian"),
        Arrays.asList("Charlie", "Arnold")
    );

    System.out.println(classes.stream()
    .flatMap(List::stream)
    .filter(name->name.startsWith("A"))
    .map(String::toUpperCase).collect(Collectors.toList()));
    



 }

   


    
}
