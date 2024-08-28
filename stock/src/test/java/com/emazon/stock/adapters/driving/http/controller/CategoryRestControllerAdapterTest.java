package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.emazon.stock.adapters.driving.http.dto.response.CategoryResponse;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(CategoryRestControllerAdapter.class)
public class CategoryRestControllerAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICategoryServicePort categoryServicePort;

    @MockBean
    private ICategoryRequestMapper categoryRequestMapper;

    @MockBean
    private ICategoryResponseMapper categoryResponseMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturn201WhenCategoryCreated() throws Exception {
        // Configurar el request y la respuesta mockeada
        var request = new AddCategoryRequest("Books", "Category for books");
        var category = new Category(1L, "Books", "Category for books");
        var response = new CategoryResponse(1L, "Books", "Category for books");

        // Mockear los métodos de mapeo y servicio
        when(categoryRequestMapper.toModel(any(AddCategoryRequest.class))).thenReturn(category);
        when(categoryServicePort.createCategory(any(Category.class))).thenReturn(category);
        when(categoryResponseMapper.toResponse(any(Category.class))).thenReturn(response);

        // Serializar el request a JSON
        String requestJson = objectMapper.writeValueAsString(request);

        // Realizar la solicitud y verificar el resultado
        mockMvc.perform(post("/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Books")))
                .andExpect(jsonPath("$.description", is("Category for books")));

    }
}