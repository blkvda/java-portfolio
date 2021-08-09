package com.home.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name="burgers")
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
public class Burger {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 4, message = "Name must be 4 char at least")
    private String name;
    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min = 1, message = "Must pick at least 1 ingredient")
    @NonNull
    private List<String> ingredients;

//    public Burger(Long id, @NotNull @Size(min = 4, message = "Name must be 4 char at least") String name, @Size(min = 1, message = "Must pick at least 1 ingredient") List<String> ingredients) {
//        this.id = id;
//        this.name = name;
//        this.ingredients = ingredients;
//    }
//
//    public Burger() {
//    }
}
