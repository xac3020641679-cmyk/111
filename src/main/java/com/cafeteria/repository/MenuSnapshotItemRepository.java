package com.cafeteria.repository;

import com.cafeteria.model.MenuSnapshotItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuSnapshotItemRepository extends JpaRepository<MenuSnapshotItem, Long> {
    MenuSnapshotItem findBySnapshotIdAndRecipeId(Long snapshotId, Long recipeId);
}
