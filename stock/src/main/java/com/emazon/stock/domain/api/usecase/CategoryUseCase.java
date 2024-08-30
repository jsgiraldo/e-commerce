package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category createCategory(Category category) {
        category.validate();
        return categoryPersistencePort.saveCategory(category);
    }
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryPersistencePort.getCategoryById(id);
    }
    @Override
    public Page<Category> listCategories(Pageable pageable) {
        return categoryPersistencePort.findAll(pageable);
    }
}
