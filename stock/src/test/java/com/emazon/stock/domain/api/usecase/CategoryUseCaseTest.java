package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    public void shouldCreateCategorySuccessfully() {
        // Crear una instancia de category válida
        Category category = new Category(null, "Books", "Category for books");
        // Configuración del mock
        when(categoryPersistencePort.saveCategory(any(Category.class))).thenReturn(category);
        // Llamada al metodo que se va a probar
        Category createdCategory = categoryUseCase.createCategory(category);
        //Verificaciones
        assertNotNull(createdCategory);
        verify(categoryPersistencePort, times(1)).saveCategory(any(Category.class));
    }

    @Test
    public void shouldThrowExceptionWhenNameIsInvalid() {
        // Crear una instancia de category con nombre inválido
        Category category = new Category(null, "", "Category without name");
        //Verificar el mensaje de la excepción
        Exception exception = assertThrows(IllegalArgumentException.class, category::validate);
        assertEquals("The category name is invalid.", exception.getMessage());
    }
    @Test
    public void shouldThrowExceptionWhenNameAlreadyExists() {
        // Configurar una categoría existente
        Category category = new Category(null, "Books", "Category for books");
        when(categoryPersistencePort.saveCategory(any(Category.class)))
                .thenThrow(new CategoryAlreadyExistsException("The category already exists."));

        // Verificar que se lanza la excepción al intentar crear la categoría duplicada
        Exception exception = assertThrows(CategoryAlreadyExistsException.class, () -> {
            categoryUseCase.createCategory(category);
        });

        assertEquals("The category already exists.", exception.getMessage());
    }
    @Test
    public void shouldThrowExceptionWhenDescriptionIsNull() {
        // Crear una categoría con descripción nula
        Category category = new Category(null, "Books", null);

        // Verificar que se lanza una excepción durante la validación
        Exception exception = assertThrows(IllegalArgumentException.class, category::validate);

        assertEquals("The category description is invalid.", exception.getMessage());
    }
    @Test
    public void shouldThrowExceptionWhenNameExceedsMaxLength() {
        // Crear una categoría con un nombre que excede el límite de 50 caracteres
        Category category = new Category(null, "A".repeat(51), "Category with a long name");

        // Verificar que se lanza una excepción durante la validación
        Exception exception = assertThrows(IllegalArgumentException.class, category::validate);

        assertEquals("The category name is invalid.", exception.getMessage());
    }
    @Test
    public void shouldThrowExceptionWhenDescriptionExceedsMaxLength() {
        // Crear una categoría con una descripción que excede el límite de 90 caracteres
        Category category = new Category(null, "Books", "A".repeat(91));

        // Verificar que se lanza una excepción durante la validación
        Exception exception = assertThrows(IllegalArgumentException.class, category::validate);

        assertEquals("The category description is invalid.", exception.getMessage());
    }

}