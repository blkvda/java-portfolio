package com.home.repositories;

import com.home.models.Burger;

public interface BurgerRepo {
    Burger add (Burger burger);
    Iterable<Burger> getBurgersByOrderId(Long orderId);
    Burger getBurgerById(Long id);
}
