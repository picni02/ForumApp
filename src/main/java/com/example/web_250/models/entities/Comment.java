package com.example.web_250.models.entities;

import com.example.web_250.models.in.CommentIn;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    private Date date;

    public Comment(CommentIn comment) {
        this.content = comment.getContent();
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(comment.getDate());
        } catch (Exception e) {}
    }

    public Comment() {

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}