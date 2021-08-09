package com.home.repositories;

import com.home.models.Ingredient;

public interface IngredientRepo {
    Iterable<Ingredient> findAll();
    Ingredient findById(Long id);
    Ingredient findByName(String name);
    Iterable<Ingredient> findByBurgerId(Long burgerId);
    Ingredient add(Ingredient ingredient);
}
