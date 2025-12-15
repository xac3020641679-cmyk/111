package com.cafeteria.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderForm order;

    private Long recipeId;
    private String recipeName;
    private Integer quantity;
    private BigDecimal unitPrice = BigDecimal.ZERO;
    private BigDecimal subtotal = BigDecimal.ZERO;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public OrderForm getOrder() { return order; }
    public void setOrder(OrderForm order) { this.order = order; }
    public Long getRecipeId() { return recipeId; }
    public void setRecipeId(Long recipeId) { this.recipeId = recipeId; }
    public String getRecipeName() { return recipeName; }
    public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public java.math.BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(java.math.BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public java.math.BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(java.math.BigDecimal subtotal) { this.subtotal = subtotal; }
}
