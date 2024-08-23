package com.emazon.stock.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private  String name;

    @Column(length = 90)
    private String description;

    //Getters and setters
}
