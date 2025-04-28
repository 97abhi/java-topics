package com.java8;
/*
 * Functional Interface
 * 
 * A functional interface is an interface with only one abstract method.
 * It can have multiple default or static methods, but just one abstract method.
 * Java 8 introduced @FunctionalInterface to enforce this rule.
 * This allows it to be used with lambda expressions or method references.
 * 
 * Strictfp
 * In Java, the strictfp is a modifier that stands for strict floating-point which was not introduced in the base version of Java as it was introduced in Java version 1.2.
 * It is used in Java for restricting floating-point calculations and ensuring the same result on every platform while performing operations in the floating-point variable. 
 */

@FunctionalInterface
interface GreetService {

//only public, abstract, default, static and strictfp are permitted   
 void greet(String name);
}


public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        GreetService greetService = (name) -> System.out.println(name);

        greetService.greet("Abhishek");
        greetService.greet("Mishra");
    }
}
