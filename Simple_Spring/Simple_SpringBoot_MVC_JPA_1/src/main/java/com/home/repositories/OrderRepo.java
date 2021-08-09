package com.home.repositories;

import com.home.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Long> {
    List<Order> findByZipcode(Integer zipcode);
    List<Order> readOrdersByZipcodeAndPlacedAtBetween(
            String deliveryZip, LocalDateTime startDate, LocalDateTime endDate);
    @Query("SELECT o FROM Order o where o.zipcode='123456'")
    List<Order> readOrdersDeliveredInSeattle();
    Order save(Order order);
}
