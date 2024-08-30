package com.emazon.stock.domain.spi;

import com.emazon.stock.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryPersistencePort {
    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Page<Category> findAll(Pageable pageable);
}
