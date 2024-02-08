package com.example.web_250.models.in;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;

public class EventIn {
    @Nullable
    private Integer Id;

    @Size(max = 255)
    private String name;

    private String date;

    @Size(max = 1000)
    private String description;

    @Size(max = 1000)
    private String imgUrl;

    private Integer categoryId;
    private Integer locationId;
    
    public EventIn() {
    }

    public Integer getId() {
        return this.Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public Integer getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getLocationId() {
        return this.locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    } 
}
