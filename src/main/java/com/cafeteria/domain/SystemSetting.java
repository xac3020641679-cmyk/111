package com.cafeteria.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "system_settings")
public class SystemSetting implements Serializable {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
