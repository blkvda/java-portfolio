package com.home.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
//@RequiredArgsConstructor
public class Burger {
    private Long id;
    @NotNull
    @Size(min = 4, message = "Name must be 4 char at least")
    private String name;
    @Size(min = 1, message = "Must pick at least 1 ingredient")
    private List<String> ingredients;

    public Burger(Long id, @NotNull @Size(min = 4, message = "Name must be 4 char at least") String name, @Size(min = 1, message = "Must pick at least 1 ingredient") List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public Burger() {
    }
}
