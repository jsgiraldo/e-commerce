package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryServicePort {
    Category createCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Page<Category> listCategories(Pageable pageable);
}
