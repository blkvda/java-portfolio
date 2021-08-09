package com.home.models;

import lombok.*;

import javax.persistence.*;

@Data //lombok создает геттеры и сеттеры
@Entity
@Table(name="ingredients")
@NoArgsConstructor(force=true)
@RequiredArgsConstructor //lombok создает конструктор для инициализации всех полей
public class Ingredient {
    @Id
    private Long id;
    @NonNull
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    public static enum Type{PROTEIN, VEGGIES, CHEESE, SAUCE};

//    public Ingredient(Long id, String name, Type type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }
//
//    public Ingredient() {
//    }
}
