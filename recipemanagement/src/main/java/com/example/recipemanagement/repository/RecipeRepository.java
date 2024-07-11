package com.example.recipemanagement.repository;



import com.example.recipemanagement.dao.RecipeEntity;
import com.example.recipemanagement.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity,Integer> {
    //Method to retrieve all recipes from repository matching with given DateTime value
    List<RecipeEntity> findRecipesByCreationDateTime(Date dateTime);

    //Method to retrieve all recipes from repository matching with given recipe type
    List<RecipeEntity> findRecipesByType(String type);

    //Method to retrieve all recipes from repository matching with given serving capacity
    List<RecipeEntity> findRecipesByServingCapacity(Integer capacity);

}