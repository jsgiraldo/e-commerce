package com.emazon.stock.adapters.driven.jpa.mysql.mapper;

import com.emazon.stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.emazon.stock.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ICategoryEntityMapperTest {

    private ICategoryEntityMapper mapper = Mappers.getMapper(ICategoryEntityMapper.class);


    @Test
    public void shouldMapCategoryToCategoryEntity() {
        Category category = new Category(1L, "Books", "Category for books");

        CategoryEntity categoryEntity = mapper.toEntity(category);

        assertEquals(category.getId(), categoryEntity.getId());
        assertEquals(category.getName(), categoryEntity.getName());
        assertEquals(category.getDescription(), categoryEntity.getDescription());
    }
    @Test
    public void shouldMapCategoryEntityToCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1L);
        categoryEntity.setName("Books");
        categoryEntity.setDescription("Category for books");

        Category category = mapper.toModel(categoryEntity);

        assertEquals(categoryEntity.getId(), category.getId());
        assertEquals(categoryEntity.getName(), category.getName());
        assertEquals(categoryEntity.getDescription(), category.getDescription());
    }
}