package com.emazon.stock.adapters.driven.jpa.mysql.adapter;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.stock.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private ICategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    private CategoryAdapter categoryAdapter;

    @Test
    void shouldSaveCategorySuccessfully() {
        Category category = new Category(null, "Books", "Category for books");
        CategoryEntity categoryEntity = new CategoryEntity();

        when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(categoryEntity);
        when(categoryEntityMapper.toEntity(category)).thenReturn(categoryEntity);
        when(categoryEntityMapper.toModel(categoryEntity)).thenReturn(category);

        Category savedCategory = categoryAdapter.saveCategory(category);

        assertEquals(category, savedCategory);
        verify(categoryRepository).save(categoryEntity);

    }
    @Test
    void shouldThrowExceptionWhenCategoryAlreadyExists() {
        when(categoryRepository.findByName("Books")).thenReturn(Optional.of(new CategoryEntity()));

        Category category = new Category(null, "Books", "Category for books");

        assertThrows(CategoryAlreadyExistsException.class, () -> {
            categoryAdapter.saveCategory(category);
        });
    }
}