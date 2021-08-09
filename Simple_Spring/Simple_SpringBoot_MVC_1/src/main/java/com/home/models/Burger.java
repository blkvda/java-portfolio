package com.home.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Burger {
    @NotNull
    @Size(min = 4, message = "Name must be 4 char at least")
    private String name;
    @Size(min = 1, message = "Must pick at least 1 ingredient")
    private List<String> ingredients;
}
