package com.cafeteria.service;

import com.cafeteria.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest request);
}
