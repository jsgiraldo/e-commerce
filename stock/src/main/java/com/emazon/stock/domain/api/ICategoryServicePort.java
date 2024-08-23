package com.emazon.stock.domain.api;

import com.emazon.stock.domain.model.Category;

public interface ICategoryServicePort {
    Category createCategory(Category category);
}
