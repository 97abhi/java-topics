

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapAPi {

    public static void main(String[] args) {
        List<List<String>> fruits = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("mango", "grape"),
                Arrays.asList("orange"));

        System.out
                .println(fruits.stream().flatMap(List::stream).map(x -> x.toUpperCase()).collect(Collectors.toList()));

        // group employees by department

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 5000),
                new Employee("Bob", "Finance", 7000),
                new Employee("Charlie", "IT", 6000),
                new Employee("David", "HR", 4500),
                new Employee("Eve", "Finance", 8000));

        Map<String, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });

        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()));

        departmentCount.forEach((dept, count) -> {
            System.out.println(dept + " -> " + count);
        });


        Map<String, Optional<Employee>> highestSalaryByDept = employees.stream()
        .collect(
            Collectors
            .groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

            

    }
}
