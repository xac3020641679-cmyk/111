package com.cafeteria.service;

import com.cafeteria.domain.OrderForm;

import java.time.LocalDate;

public interface OrderService {
    OrderForm placeOrder(Long userId, Long menuSnapshotId, OrderForm order) throws Exception;
    void cancelOrder(Long orderId) throws Exception;
}
