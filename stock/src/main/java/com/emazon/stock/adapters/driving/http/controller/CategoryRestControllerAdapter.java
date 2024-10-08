package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryRestControllerAdapter {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    public CategoryRestControllerAdapter(ICategoryServicePort categoryServicePort, ICategoryRequestMapper categoryRequestMapper, ICategoryResponseMapper categoryResponseMapper) {
        this.categoryServicePort = categoryServicePort;
        this.categoryRequestMapper = categoryRequestMapper;
        this.categoryResponseMapper = categoryResponseMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody AddCategoryRequest request) {
        Category category = categoryRequestMapper.toModel(request);
        System.out.println("Category mapped from request: " + category);
        Category createdCategory = categoryServicePort.createCategory(category);
        System.out.println("Created Category: " + createdCategory);
        CategoryResponse response = categoryResponseMapper.toResponse(createdCategory);

        System.out.println("Response being returned: " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
