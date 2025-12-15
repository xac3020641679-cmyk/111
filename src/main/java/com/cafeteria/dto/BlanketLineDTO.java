package com.cafeteria.dto;

public class BlanketLineDTO {
    private Long recipeId;
    private String recipeName;
    private int quantity;

    public BlanketLineDTO() {}
    public BlanketLineDTO(Long recipeId, String recipeName, int quantity) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.quantity = quantity;
    }

    public Long getRecipeId() { return recipeId; }
    public void setRecipeId(Long recipeId) { this.recipeId = recipeId; }
    public String getRecipeName() { return recipeName; }
    public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
