package com.cafeteria.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface MenuService {
    void publishMenu(List<Long> recipeIds, Map<Long, BigDecimal> priceOverrides);
}
