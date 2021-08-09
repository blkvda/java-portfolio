package com.home.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
//@RequiredArgsConstructor
public class Order {
    private Long id;
    private LocalDateTime placedAt;
    @NotNull
    @Size(min = 4, max = 30, message = "Name must be 4-30 chars")
    private String name;
    @NotBlank
    private String street;
    @Digits(integer = 6, fraction = 0, message = "Incorrect ZIP code")
    private Integer zipcode;

    public Order(Long id, LocalDateTime placedAt, @NotNull @Size(min = 4, max = 30, message = "Name must be 4-30 chars") String name, @NotBlank String street, @Digits(integer = 6, fraction = 0, message = "Incorrect ZIP code") Integer zipcode) {
        this.id = id;
        this.placedAt = placedAt;
        this.name = name;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Order() {
    }
}
