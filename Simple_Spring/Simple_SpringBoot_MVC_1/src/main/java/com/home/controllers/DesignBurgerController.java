package com.home.controllers;

import com.home.models.Burger;
import com.home.models.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignBurgerController {
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(0, "Ketchup", Ingredient.Type.SAUCE));
        ingredients.add(new Ingredient(1, "Mayonnaise", Ingredient.Type.SAUCE));
        ingredients.add(new Ingredient(2, "Cheddar", Ingredient.Type.CHEESE));
        ingredients.add(new Ingredient(3, "Parmesan", Ingredient.Type.CHEESE));
        ingredients.add(new Ingredient(4, "Tomato", Ingredient.Type.VEGGIES));
        ingredients.add(new Ingredient(5, "Pickle", Ingredient.Type.VEGGIES));
        ingredients.add(new Ingredient(6, "Beef", Ingredient.Type.PROTEIN));
        ingredients.add(new Ingredient(7, "Pork", Ingredient.Type.PROTEIN));
        ingredients.add(new Ingredient(8, "Chicken", Ingredient.Type.PROTEIN));
        ingredients.add(new Ingredient(9, "Shrimp", Ingredient.Type.PROTEIN));

        for (Ingredient.Type type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Burger());
        return "design";
    }

    public List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream().filter(x -> x.getType() == type).collect(Collectors.toList());
    }

    @PostMapping
    //@Valid - сообщает Spring вып валидацию связанного объекта перед вып метода
    public String serviceDesign(@Valid Burger burger, Errors errors){
        if(errors.hasErrors()){
            return "design";
        }
        System.out.println("Input Burger: " + burger);
        return "redirect:/orders";
    }

}
