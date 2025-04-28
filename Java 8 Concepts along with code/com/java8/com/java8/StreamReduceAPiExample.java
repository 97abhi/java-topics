package com.java8;

import java.util.Arrays;
import java.util.List;

/*
 * The reduce() method in the Stream API is a terminal operation that c
 * ombines elements of the stream into a single result.
 * It’s often used for accumulation, aggregation, or combining values from a stream 
 * (e.g., sum, product, concatenation).
 * 
 * 
 * Initial value: The first argument of reduce() is the identity value (e.g., 0 for sum, "" for concatenation).
 * Accumulator: The second argument is a binary function that combines the two elements (e.g., (a, b) -> a + b for sum).
 * Optional result: The result is wrapped in an Optional because there could be no elements to reduce (if the stream is empty).
 * 
 * 
 * 
 * When to use reduce()?
 * reduce() is useful for operations that need to combine elements in a reduction operation, 
 * like summing up values, finding min/max, or accumulating results.
 */

class Transaction {
    private String type;
    private int amount;

    // Constructor
    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getters
    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}

public class StreamReduceAPiExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        List<String> words = Arrays.asList("Hello", "world", "Java");

        System.out.println(words.stream().reduce("", (a, b) -> a + " " + b).trim());

        System.out.println(numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> (a > b) ? a : b));

        List<Transaction> transactions = Arrays.asList(
                new Transaction("credit", 100),
                new Transaction("debit", 50),
                new Transaction("credit", 200),
                new Transaction("debit", 30),
                new Transaction("credit", 150));

        System.out.println("FINAL AMOUNT " + transactions
        .stream()
        .filter(transaction -> transaction.getType().equals("credit"))
        .map(transaction -> transaction.getAmount())
        .reduce(0,(a,b)->a+b));

    }
}
