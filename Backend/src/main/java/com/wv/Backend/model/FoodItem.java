package com.wv.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity //Tells Spring/Hibernate that this class is meant to be stored in the database.
@Data   // (from Lombok) Automatically generates getters, setters, toString(), equals(), hashCode() —
        // so you don’t have to write boilerplate code.
public class FoodItem {
    @Id//Marks the primary key of the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private boolean available;
}
