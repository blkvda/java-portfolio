package com.home.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="orders")
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private LocalDateTime placedAt;
    @NotNull
    @Size(min = 4, max = 30, message = "Name must be 4-30 chars")
    private String name;
    @NotBlank
    private String street;
    @NonNull
    @Digits(integer = 6, fraction = 0, message = "Incorrect ZIP code")
    private Integer zipcode;
    @ManyToMany(targetEntity=Burger.class)
    private List<Burger> tacos = new ArrayList<>();

    @PrePersist
    void placedAt() {
        this.placedAt = LocalDateTime.now();
    }

//    public Order(Long id, LocalDateTime placedAt, @NotNull @Size(min = 4, max = 30, message = "Name must be 4-30 chars") String name, @NotBlank String street, @Digits(integer = 6, fraction = 0, message = "Incorrect ZIP code") Integer zipcode, List<Burger> tacos) {
//        this.id = id;
//        this.placedAt = placedAt;
//        this.name = name;
//        this.street = street;
//        this.zipcode = zipcode;
//        this.tacos = tacos;
//    }
//
//    public Order() {
//    }
}
