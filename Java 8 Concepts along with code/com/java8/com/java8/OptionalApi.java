package com.java8;

import java.util.Optional;

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}

class User {
    private Address address;

    public User(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

public class OptionalApi {

    public static void main(String[] args) {
        User userWithAddress = new User(new Address("New York"));
        User userWithoutAddress = new User(null);

        System.out.println(getCity(userWithAddress));  // Output: New York
        System.out.println(getCity(userWithoutAddress));  
    }
    static String getCity(User user) {
        return Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .orElse("Unknown");
    }

}
