package com.example.recipemanagement;

import com.example.recipemanagement.controller.RecipeController;
import com.example.recipemanagement.model.Recipe;
import com.example.recipemanagement.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    @WithMockUser
    public void testGetAllRecipes() throws Exception {
        Recipe recipe = new Recipe(); // set properties
        when(recipeService.getAllRecipes()).thenReturn(Arrays.asList(recipe));

        mockMvc.perform(get("/api/v1/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").exists());
    }

    @Test
    @WithMockUser
    public void testCreateRecipe() throws Exception {
        Recipe recipe = new Recipe(); // set properties
        when(recipeService.createRecipe(any(Recipe.class))).thenReturn(recipe);

        mockMvc.perform(post("/api/v1/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")) // Add JSON content
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());
    }

    // Add more tests for other endpoints
}