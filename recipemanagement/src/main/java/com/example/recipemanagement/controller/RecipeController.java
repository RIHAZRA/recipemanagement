package com.example.recipemanagement.controller;

import com.example.recipemanagement.model.Recipe;
import com.example.recipemanagement.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/recipes")
    public class RecipeController {

        @Autowired
        private RecipeService recipeService;

        @GetMapping
        public ResponseEntity<List<Recipe>> getAllRecipes() {
            return ResponseEntity.ok(recipeService.getAllRecipesFromRepository());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id) {
            return ResponseEntity.ok(recipeService.getRecipeFromRepository(id));
        }

        @PostMapping
        public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
            return new ResponseEntity<>(recipeService.saveRecipeToRepository(recipe), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
            return ResponseEntity.ok(recipeService.modifyExistingRecipeInRepository(id, recipe));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
            recipeService.deleteRecipeFromRepository(id);
            return ResponseEntity.noContent().build();
        }
    }

