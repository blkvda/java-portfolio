package com.home.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data //lombok создает геттеры и сеттеры
@RequiredArgsConstructor //lombok создает конструктор для инициализации всех полей
public class Ingredient {
    private final int id;
    private final String name;
    private final Type type;

    public static enum Type{PROTEIN, VEGGIES, CHEESE, SAUCE};
}
