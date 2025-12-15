package com.cafeteria.repository;

import com.cafeteria.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderOrderDate(LocalDate orderDate);
    List<OrderItem> findByOrderOrderDateBetween(LocalDate start, LocalDate end);
}
