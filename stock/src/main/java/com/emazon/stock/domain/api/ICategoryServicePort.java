package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;

import java.util.Optional;

public interface ICategoryServicePort {
    Category createCategory(Category category);
    Optional<Category> getCategoryById(Long id);
}
