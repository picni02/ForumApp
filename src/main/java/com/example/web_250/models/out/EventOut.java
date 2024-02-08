package com.example.web_250.models.out;

import java.util.Date;

import com.example.web_250.models.entities.Event;

public class EventOut {
    private Integer Id;
    private String name;
    private Date date;
    private String description;
    private Integer categoryId;
    public EventOut() {
    }
    public EventOut(Event event) {
        this.Id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.description = event.getDescription();
        this.categoryId = event.getCategory().getId();
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
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
}
