package com.cafeteria.repository;

import com.cafeteria.model.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface OrderRepository extends JpaRepository<OrderForm, Long> {
    boolean existsByUserIdAndOrderDate(Long userId, LocalDate orderDate);
}
