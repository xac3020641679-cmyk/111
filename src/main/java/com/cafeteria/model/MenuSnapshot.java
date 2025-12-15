package com.cafeteria.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MENU_SNAPSHOT")
public class MenuSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate publishDate;

    @OneToMany(mappedBy = "snapshot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuSnapshotItem> items = new ArrayList<>();

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getPublishDate() { return publishDate; }
    public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }
    public List<MenuSnapshotItem> getItems() { return items; }
    public void setItems(List<MenuSnapshotItem> items) { this.items = items; }
}
