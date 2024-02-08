package com.example.web_250.models.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;
import com.example.web_250.models.in.EventIn;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Size(max = 255)
    private String name;

    private Date date;

    @Size(max = 1000)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Event() {
    }

    public Event(EventIn eventIn) {
        this.Id = eventIn.getId();
        this.name = eventIn.getName();
        try {
            this.date = new SimpleDateFormat("MM/dd/yyyy").parse(eventIn.getDate());
        } catch (Exception e) {}
        this.description = eventIn.getDescription();
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

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
