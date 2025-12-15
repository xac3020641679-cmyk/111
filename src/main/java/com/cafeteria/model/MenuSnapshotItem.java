package com.cafeteria.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "MENU_SNAPSHOT_ITEM")
public class MenuSnapshotItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "snapshot_id")
    private MenuSnapshot snapshot;

    private Long recipeId;
    private String recipeName;
    private BigDecimal price = BigDecimal.ZERO;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public MenuSnapshot getSnapshot() { return snapshot; }
    public void setSnapshot(MenuSnapshot snapshot) { this.snapshot = snapshot; }
    public Long getRecipeId() { return recipeId; }
    public void setRecipeId(Long recipeId) { this.recipeId = recipeId; }
    public String getRecipeName() { return recipeName; }
    public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(java.math.BigDecimal price) { this.price = price; }
}
