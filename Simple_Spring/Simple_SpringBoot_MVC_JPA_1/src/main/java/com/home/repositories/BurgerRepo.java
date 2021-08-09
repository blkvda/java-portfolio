package com.home.repositories;

import com.home.models.Burger;
import org.springframework.data.repository.CrudRepository;

public interface BurgerRepo extends CrudRepository<Burger, Long> {
    Burger findById(long id);
    Burger save(Burger burger);
}
