package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Category;

import java.util.Optional;

public interface ICategoryPersistencePort {
    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Long id);
}
