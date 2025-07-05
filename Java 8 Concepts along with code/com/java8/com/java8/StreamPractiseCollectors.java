

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;



class Product {
    private String name;
    private String category;
    private int price;

    // Constructor
    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name; // Just return the product name for easy printing
    }
}

class Student {
    private String name;
    private List<String> subjects;

    public Student(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}

 class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {  // 💥 Must have this constructor
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class StreamPractiseCollectors {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 800),
                new Product("Mouse", "Electronics", 40),
                new Product("Shirt", "Clothing", 150),
                new Product("Pants", "Clothing", 90),
                new Product("Juicer", "Home Appliances", 200),
                new Product("Blender", "Home Appliances", 80));

        Map<String, List<Product>> result = products.stream()
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.groupingBy(Product::getCategory));

        result.forEach((category, productList) -> {
            System.out.println(category + " -> " + productList);
        });

        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList("Math", "Physics")),
                new Student("Bob", Arrays.asList("Chemistry", "Biology")),
                new Student("Charlie", Arrays.asList("History", "Math")));

        System.out.println(
                students.stream().flatMap(student -> student.getSubjects().stream()).collect(Collectors.toList()));
        System.out.println(
                students.stream().flatMap(student -> student.getSubjects().stream()).collect(Collectors.toSet()));
        System.out.println(students.stream().flatMap(student -> student.getSubjects().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new)));

                List<Employee> employees = Arrays.asList(
                    new Employee("Alice", "IT", 5000),
                    new Employee("Bob", "Finance", 7000),
                    new Employee("Charlie", "IT", 6000),
                    new Employee("David", "HR", 4500),
                    new Employee("Eve", "Finance", 8000)
                );
                

        // Map<String, Optional<Employee>> employee = employees.stream()
        //         .collect(Collectors.groupingBy(Employee::getDepartment,
        //                 Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        // employee.forEach((k, v) -> {
        //     System.out.println(k + " " + v.get());
        // });

    }
}
