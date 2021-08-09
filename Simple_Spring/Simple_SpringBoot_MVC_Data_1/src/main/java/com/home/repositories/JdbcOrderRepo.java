package com.home.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.models.Burger;
import com.home.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcOrderRepo implements OrderRepo {
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert burgersOrdersInserter;

    @Autowired
    public JdbcOrderRepo(JdbcTemplate jdbcTemplate) {
        this.orderInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("orders")
                .usingGeneratedKeyColumns("id");
        this.burgersOrdersInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("burgers_orders");
    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Order add(Order order) {
        order.setPlacedAt(LocalDateTime.now());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        return order;
    }

    private long saveOrderDetails(Order order){
        Map<String, Object> values = new ObjectMapper().convertValue(order, Map.class);
        long orderId = orderInserter.executeAndReturnKey(values).longValue();
        return orderId;
    }
}
