import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {
    
    //Find the first non repeating character in a string 
    public static void main(String[] args) {
     String arr = "Abhishek";
     Map<Character, Long> map = arr.chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
     System.out.println(map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().get());
        
    }

}
