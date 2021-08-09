package com.home.controllers;

import com.home.models.Burger;
import com.home.models.Ingredient;
import com.home.models.Order;
import com.home.repositories.BurgerRepo;
import com.home.repositories.IngredientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignBurgerController {
    private IngredientRepo ingredientRepo;
    private BurgerRepo burgerRepo;

    @Autowired
    public DesignBurgerController(IngredientRepo ingredientRepo, BurgerRepo burgerRepo) {
        this.ingredientRepo = ingredientRepo;
        this.burgerRepo = burgerRepo;
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(x -> ingredients.add(x));

        for (Ingredient.Type type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Burger());
        return "design";
    }

    public List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }
    @ModelAttribute(name = "burger")
    public Burger burger() {
        return new Burger();
    }


    @PostMapping
    //@Valid - сообщает Spring вып валидацию связанного объекта перед вып метода
    public String serviceDesign(@Valid Burger burger, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "design";
        }

        Burger newBurger = burgerRepo.save(burger);
        //order.addDesign();
        return "redirect:/orders";
    }

}
