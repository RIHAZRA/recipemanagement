package com.example.recipemanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Recipe {
    private Integer id;
    private String name;
    private String type;
    private Integer servingCapacity;
    private List<Ingredient> ingredientsList = new ArrayList<>();
    private Date creationDateTime;
    private String instructions;
    private String cDateTimeString;
}