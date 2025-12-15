package com.cafeteria.service;

import com.cafeteria.model.MenuSnapshot;
import com.cafeteria.model.MenuSnapshotItem;
import com.cafeteria.model.Recipe;
import com.cafeteria.repository.MenuSnapshotItemRepository;
import com.cafeteria.repository.MenuSnapshotRepository;
import com.cafeteria.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    private final RecipeRepository recipeRepository;
    private final MenuSnapshotRepository snapshotRepository;
    private final MenuSnapshotItemRepository itemRepository;

    public MenuServiceImpl(RecipeRepository recipeRepository, MenuSnapshotRepository snapshotRepository, MenuSnapshotItemRepository itemRepository) {
        this.recipeRepository = recipeRepository;
        this.snapshotRepository = snapshotRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public void publishMenu(List<Long> recipeIds, Map<Long, BigDecimal> priceOverrides) {
        MenuSnapshot snapshot = new MenuSnapshot();
        snapshot.setPublishDate(LocalDate.now());

        for (Long rid : recipeIds) {
            Optional<Recipe> r = recipeRepository.findById(rid);
            if (!r.isPresent()) continue;
            MenuSnapshotItem item = new MenuSnapshotItem();
            item.setSnapshot(snapshot);
            item.setRecipeId(rid);
            item.setRecipeName(r.get().getName());
            BigDecimal price = priceOverrides != null && priceOverrides.containsKey(rid) ? priceOverrides.get(rid) : BigDecimal.valueOf(5.00);
            item.setPrice(price);
            snapshot.getItems().add(item);
        }

        snapshotRepository.save(snapshot);
    }
}
