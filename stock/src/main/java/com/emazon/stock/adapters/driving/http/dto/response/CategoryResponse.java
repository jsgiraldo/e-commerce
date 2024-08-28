package com.emazon.stock.adapters.driving.http.dto.response;

public class CategoryResponse {
    private Long id;
    private String name;
    private  String description;

    // Constructor que acepta parámetros

    public CategoryResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
