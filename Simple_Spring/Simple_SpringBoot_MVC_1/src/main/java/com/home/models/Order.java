package com.home.models;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Order {
    @NotNull
    @Size(min = 4, max = 30, message = "Name must be 4-30 chars")
    private String name;
    @NotBlank
    private String street;
    @Digits(integer = 6, fraction = 0, message = "Incorrect ZIP code")
    private Integer zipcode;
}
