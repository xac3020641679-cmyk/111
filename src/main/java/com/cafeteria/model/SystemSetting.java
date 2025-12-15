package com.cafeteria.model;

import javax.persistence.*;

@Entity
@Table(name = "SYSTEM_SETTING")
public class SystemSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "setting_key", unique = true)
    private String key;

    @Column(name = "setting_value")
    private String value;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
