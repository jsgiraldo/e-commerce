package com.emazon.stock.configuration;

import com.emazon.stock.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.emazon.stock.adapters.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.mysql.repository.ICategoryRepository;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.domain.api.usecase.CategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ICategoryServicePort categoryServicePort(ICategoryPersistencePort categoryPersistencePort) {
        return new CategoryUseCase(categoryPersistencePort);
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper) {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }
}
