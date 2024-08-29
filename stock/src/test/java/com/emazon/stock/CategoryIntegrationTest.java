package com.emazon.stock;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CategoryIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateCategoryAndPersistToDatabase() throws Exception {
        mockMvc.perform(post("/categories")
                        .contentType("application/json")
                        .content("{\"name\":\"Books\",\"description\":\"Category for books\"}"))
                .andExpect(status().isCreated());

    }
}
