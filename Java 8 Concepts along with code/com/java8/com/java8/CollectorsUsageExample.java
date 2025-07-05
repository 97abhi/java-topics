

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * When to use Collectors:
 * Use Collectors.toList() or Collectors.toSet() when you need to gather elements into a specific collection type.
 * Use Collectors.groupingBy() when you need to group elements based on a criterion.
 * Use Collectors.joining() when you want to concatenate strings.
 * Use Collectors.summarizingInt(), Collectors.summarizingDouble(), or Collectors.summarizingLong() for statistics (e.g., finding sum, min, max, etc.).
 * Use Collectors.reducing() for more general reductions when you want to combine elements into a single result.
 */
class Employee {
    private String name;
    private int salary;
    private String department;

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Constructor, getters, and setters
}

public class CollectorsUsageExample {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        System.out.println(words.stream().filter(word -> word.length() > 5).collect(Collectors.toList()));

        List<String> wordsExtra = Arrays.asList("apple", "banana", "apple", "cherry");

        System.out.println(wordsExtra.stream().filter(names -> names.length() > 3).collect(Collectors.toSet()));

        System.out.println(words.stream().collect(Collectors.joining(",")));

        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));

        System.out.println(words.stream().collect(Collectors.groupingBy(name -> name.startsWith("a"))));

        System.out.println(words.stream().collect(Collectors.partitioningBy(name -> name.length() > 5)));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().collect(Collectors.reducing(0, Integer::sum)));

        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000, "HR"),
                new Employee("Anna", 7000, "IT"),
                new Employee("Tom", 6000, "HR"),
                new Employee("Mary", 8000, "IT"),
                new Employee("Alex", 7500, "HR"));

    //The taask is 
    /*
     * Group employees by their department.
     * Calculate the average salary of employees in each department.
     * List the employees who have salaries above the average for their department.
     */

     Map<String, List<Employee>>map = employees.stream()
     .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> mapByAverageSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingInt(Employee::getSalary)));
        
        System.out.println(mapByAverageSalary);

        List<String> employeeName = employees.stream()
        .filter(emp -> emp.getSalary() > mapByAverageSalary.get(emp.getDepartment()))
        .map(Employee::getName).collect(Collectors.toList());

        employeeName.stream().forEach(System.out::println);


        List<Integer> numbersList = Arrays.asList(12, 35, 9, 47, 28, 5, 68, 30, 14);

        Map<Boolean,List<Integer>> maps = numbersList.stream().collect(Collectors.partitioningBy(n -> n%2 ==0));

        System.out.println(maps);
        List<Integer> evenNumbers = maps.get(true);
        List<Integer> oddNumbers = maps.get(false);
        
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
        

    }
}
