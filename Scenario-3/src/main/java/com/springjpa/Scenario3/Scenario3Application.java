package com.springjpa.Scenario3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Scenario3Application {

    public static void main(String[] args) {
        SpringApplication.run(Scenario3Application.class, args);
    }

}


//Scenario 4: Advanced (Orders & Products)
//🛒 Task:
//
//Create a Product entity with fields (id, name, price).
//Create an Order entity with fields (id, orderDate).
//Since an Order can contain multiple Products and a Product can be in multiple Orders, create a join table with an extra field (quantity).
//Write a JPA query to fetch all Products for a given Order with quantity.
//Implement a Spring Boot API to:
//Place a new order with multiple products.
//Get details of an order with products and quantity.