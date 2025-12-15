package com.cafeteria.controller;

import com.cafeteria.dto.OrderRequest;
import com.cafeteria.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> place(@RequestBody OrderRequest request) {
        orderService.placeOrder(request);
        return ResponseEntity.ok("order placed");
    }
}
