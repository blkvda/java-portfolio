package com.home.repositories;

import com.home.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class JdbcIngredientRepo implements IngredientRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("SELECT * FROM ingredients", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ingredients WHERE id = ?", this::mapRowToIngredient, id);
    }

    @Override
    public Iterable<Ingredient> findByBurgerId(Long burgerId) {
        Iterable<Long> ingredientsIdList = jdbcTemplate.query("SELECT ingredient FROM burgers_ingredients WHERE burger = ?",
                (rs, rowNum) -> rs.getLong("ingredient"),
                burgerId);

        ArrayList<Ingredient> result = new ArrayList<>();
        for(Long ingredientId : ingredientsIdList){
            result.add(jdbcTemplate.queryForObject("SELECT * FROM ingredients WHERE id = ?",
                    this::mapRowToIngredient,
                    ingredientId));
        }
        return result;
    }

    @Override
    public Ingredient findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM ingredients WHERE name = ?", this::mapRowToIngredient, name);
    }

    @Override
    public Ingredient add(Ingredient ingredient) {
        jdbcTemplate.update(
                "INSERT INTO ingredients (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(rs.getLong("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}
