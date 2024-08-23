package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;

import java.util.Optional;

public class CategoryAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    public CategoryAdapter(ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public Category saveCategory(Category category) {
        Optional<CategoryEntity> existingCategory = categoryRepository.findByName(category.getName());
        if (existingCategory.isPresent()) {
            throw new CategoryAlreadyExistsException("The category already exists.");
        }
        CategoryEntity categoryEntity = categoryEntityMapper.toEntity(category);
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return categoryEntityMapper.toModel(savedCategoryEntity);
    }
}
