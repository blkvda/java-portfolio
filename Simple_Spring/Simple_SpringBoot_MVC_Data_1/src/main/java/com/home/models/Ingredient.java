package com.home.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data //lombok создает геттеры и сеттеры
//@RequiredArgsConstructor //lombok создает конструктор для инициализации всех полей
public class Ingredient {
    private Long id;
    private String name;
    private Type type;

    public static enum Type{PROTEIN, VEGGIES, CHEESE, SAUCE};

    public Ingredient(Long id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Ingredient() {
    }
}
