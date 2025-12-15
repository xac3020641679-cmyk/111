package com.cafeteria.service;

import com.cafeteria.domain.OrderForm;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    // NOTE: This implementation is a skeleton. Integrate with your DAO/repository layer.

    @Override
    public OrderForm placeOrder(Long userId, Long menuSnapshotId, OrderForm order) throws Exception {
        // 1. check deadline from system settings (pseudo)
        String deadline = "09:00"; // TODO: load from SystemSetting repository
        LocalTime dead = LocalTime.parse(deadline);
        LocalTime now = LocalTime.now();

        if (now.isAfter(dead)) {
            throw new Exception("订餐截止时间已过，无法为当天下单。");
        }

        // 2. check if user already has an order for today (pseudo)
        LocalDate today = LocalDate.now();
        // TODO: query orders by userId and orderDate
        boolean exists = false;
        if (exists) {
            throw new Exception("今天已经有一张订单，不能重复下单。若需修改请使用修改接口。");
        }

        // 3. validate items, calculate totals, save order
        order.setUserId(userId);
        order.setCreatedAt(LocalDateTime.now());
        order.setOrderDate(today);
        // TODO: compute totalPrice from items

        // TODO: persist order via repository
        return order;
    }

    @Override
    public void cancelOrder(Long orderId) throws Exception {
        // TODO: implement cancel logic
    }
}
