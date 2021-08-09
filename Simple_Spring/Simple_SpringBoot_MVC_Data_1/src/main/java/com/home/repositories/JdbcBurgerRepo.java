package com.home.repositories;

import com.home.models.Burger;
import com.home.models.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class JdbcBurgerRepo implements BurgerRepo {
    private JdbcTemplate jdbcTemplate;
    private IngredientRepo ingredientRepo;

    @Autowired
    public JdbcBurgerRepo(JdbcTemplate jdbcTemplate, IngredientRepo ingredientRepo) {
        this.jdbcTemplate = jdbcTemplate;
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Iterable<Burger> getBurgersByOrderId(Long orderId) {
        Iterable<Long> burgersId = jdbcTemplate.query("SELECT * FROM burgers_orders WHERE burgerOrder = ?",
                (rs, rowNum) -> rs.getLong("burger"),
                orderId);
        ArrayList<Burger> result = new ArrayList<>();
        for(Long burgerId : burgersId){
            result.add(this.getBurgerById(burgerId));
        }
        return result;
    }

    @Override
    public Burger getBurgerById(Long id) {
        Iterable<Ingredient> ingredients = ingredientRepo.findByBurgerId(id);
        ArrayList<String> ingredientsTypesList = new ArrayList<>();
        ingredients.forEach(x -> ingredientsTypesList.add(x.getType().name()));

        Burger result = jdbcTemplate.queryForObject("SELECT * FROM burgers WHERE id = ?",
                (rs, rowNum) -> new Burger(rs.getLong("id"),
                                        rs.getString("name"),
                                        ingredientsTypesList),
                        id);
        return result;
    }

    @Override
    public Burger add(Burger burger) {
        long burgerId = saveBurgerInfo(burger);
        burger.setId(burgerId);
        for(String ingredientName : burger.getIngredients()){
            saveIngredientsOfBurger(ingredientRepo.findByName(ingredientName), burgerId);
        }
        return burger;
    }

    private long saveBurgerInfo(Burger burger){
        PreparedStatementCreator preparedStatementCreator =
                new PreparedStatementCreatorFactory("insert into burgers (name) values (?)", Types.VARCHAR).
                        newPreparedStatementCreator(Arrays.asList(burger.getName()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientsOfBurger(Ingredient ingredient, long burgerId) {
        jdbcTemplate.update("insert into burgers_ingredients (burger, ingredient) " +
                        "values (?, ?)",
                burgerId, ingredient.getId());
    }
}
