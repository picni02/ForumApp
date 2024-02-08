package com.example.web_250.models.in;

import org.springframework.lang.Nullable;
import javax.validation.constraints.Size;

public class CategoryIn {
    @Nullable
    private Integer id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String icon;

    public CategoryIn() {
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
