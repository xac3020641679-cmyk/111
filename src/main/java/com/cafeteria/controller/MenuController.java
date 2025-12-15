package com.cafeteria.controller;

import com.cafeteria.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody PublishRequest req) {
        menuService.publishMenu(req.getRecipeIds(), req.getPriceOverrides());
        return ResponseEntity.ok("published");
    }

    public static class PublishRequest {
        private List<Long> recipeIds;
        private Map<Long, BigDecimal> priceOverrides;
        public List<Long> getRecipeIds() { return recipeIds; }
        public void setRecipeIds(List<Long> recipeIds) { this.recipeIds = recipeIds; }
        public Map<Long, BigDecimal> getPriceOverrides() { return priceOverrides; }
        public void setPriceOverrides(Map<Long, BigDecimal> priceOverrides) { this.priceOverrides = priceOverrides; }
    }
}
