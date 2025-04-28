package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class PartitioningByApi {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
    new Student("Alice", 85),
    new Student("Bob", 35),
    new Student("Charlie", 60),
    new Student("David", 30),
    new Student("Eve", 90)
);
       students.stream().collect(Collectors.partitioningBy(x -> x.getMarks() > 40)).forEach((K,V)->{
        if(K){
            System.out.println(V  + " has passed");
        }
        else{
            System.out.println(V  + " has failed");
        }
       });

       students.stream()
    .collect(Collectors.partitioningBy(x -> x.getMarks() > 40))
    .forEach((passed, studentList) -> {
        if (passed) {
            System.out.println("Passed students: ");
            studentList.forEach(student -> System.out.println(student.getName()));
        } else {
            System.out.println("Failed students: ");
            studentList.forEach(student -> System.out.println(student.getName()));
        }
    });

    }

}
