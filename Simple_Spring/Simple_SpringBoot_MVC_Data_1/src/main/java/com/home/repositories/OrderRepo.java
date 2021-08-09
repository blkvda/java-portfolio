package com.home.repositories;

import com.home.models.Order;

public interface OrderRepo {
    Iterable<Order> findAll();
    Order add(Order order);
}
