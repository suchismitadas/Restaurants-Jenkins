package com.example.demo;

public class RestaurantNotFoundException extends RuntimeException {

    RestaurantNotFoundException(Long id) {
        super("This restaurant does not exist " + id);
    }
}
