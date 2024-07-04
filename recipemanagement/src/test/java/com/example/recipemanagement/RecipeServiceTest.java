package com.example.recipemanagement;

import com.example.recipemanagement.model.Recipe;
import com.example.recipemanagement.repository.RecipeRepository;
import com.example.recipemanagement.service.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRecipe() {
        Recipe recipe = new Recipe(); // set properties
        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);

        Recipe created = recipeService.createRecipe(recipe);

        assertNotNull(created);
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    public void testGetRecipeById() {
        Recipe recipe = new Recipe(); // set properties
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        Recipe found = recipeService.getRecipeById(1L);

        assertNotNull(found);
        verify(recipeRepository, times(1)).findById(1L);
    }

    // Add more tests for other service methods
}
