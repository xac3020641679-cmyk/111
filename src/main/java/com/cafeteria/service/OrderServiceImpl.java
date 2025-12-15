package com.cafeteria.service;

import com.cafeteria.dto.OrderItemRequest;
import com.cafeteria.dto.OrderRequest;
import com.cafeteria.model.MenuSnapshotItem;
import com.cafeteria.model.OrderForm;
import com.cafeteria.model.OrderItem;
import com.cafeteria.model.SystemSetting;
import com.cafeteria.repository.MenuSnapshotItemRepository;
import com.cafeteria.repository.OrderItemRepository;
import com.cafeteria.repository.OrderRepository;
import com.cafeteria.repository.SystemSettingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final MenuSnapshotItemRepository menuSnapshotItemRepository;
    private final SystemSettingRepository systemSettingRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, MenuSnapshotItemRepository menuSnapshotItemRepository, SystemSettingRepository systemSettingRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.menuSnapshotItemRepository = menuSnapshotItemRepository;
        this.systemSettingRepository = systemSettingRepository;
    }

    @Override
    @Transactional
    public void placeOrder(OrderRequest request) {
        // check deadline
        Optional<SystemSetting> deadlineOpt = systemSettingRepository.findByKey("order_deadline");
        if (deadlineOpt.isPresent()) {
            String v = deadlineOpt.get().getValue();
            // simple check: if deadline is 'CLOSED' -> reject
            if ("CLOSED".equalsIgnoreCase(v)) {
                throw new IllegalStateException("Ordering is closed");
            }
        }

        LocalDate today = LocalDate.now();
        if (orderRepository.existsByUserIdAndOrderDate(request.getUserId(), today)) {
            throw new IllegalStateException("User already ordered today");
        }

        OrderForm order = new OrderForm();
        order.setUserId(request.getUserId());
        order.setOrderDate(today);

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequest i : request.getItems()) {
            // find price from latest snapshot item by recipe id - naive: first found
            MenuSnapshotItem snapshotItem = menuSnapshotItemRepository.findBySnapshotIdAndRecipeId(i.getSnapshotId(), i.getRecipeId());
            BigDecimal unit = snapshotItem != null ? snapshotItem.getPrice() : BigDecimal.ZERO;
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setRecipeId(i.getRecipeId());
            oi.setRecipeName(i.getRecipeName());
            oi.setQuantity(i.getQuantity());
            oi.setUnitPrice(unit);

            BigDecimal subtotal = unit.multiply(BigDecimal.valueOf(i.getQuantity()));
            oi.setSubtotal(subtotal);
            order.getItems().add(oi);
            total = total.add(subtotal);
        }

        order.setTotal(total);
        orderRepository.save(order);
    }
}
