package com.cafeteria.repository;

import com.cafeteria.model.MenuSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuSnapshotRepository extends JpaRepository<MenuSnapshot, Long> {
}
