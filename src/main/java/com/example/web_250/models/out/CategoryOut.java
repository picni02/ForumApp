package com.example.web_250.models.out;

import com.example.web_250.models.entities.Category;

public class CategoryOut {
    private Integer id;
    private String name;
    private String icon;

    public CategoryOut() {
    }

    public CategoryOut(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.icon = category.getIcon();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    } 
}
