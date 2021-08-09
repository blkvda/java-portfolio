package com.home.repositories;

import com.home.models.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepo extends CrudRepository<Ingredient, Long> {
    Ingredient findById(long id);
    Ingredient save(Ingredient ingredient);
    Iterable<Ingredient> findAll();
}
