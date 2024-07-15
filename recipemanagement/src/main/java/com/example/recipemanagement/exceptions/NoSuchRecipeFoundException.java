package com.example.recipemanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchRecipeFoundException extends ResponseStatusException {

    public NoSuchRecipeFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}