package com.example.recipemanagement.repository;



import com.example.recipemanagement.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}