package com.example.web_250.models.out;

import com.example.web_250.models.entities.User;
import com.example.web_250.models.entities.Comment;

import java.util.Date;

public class CommentOut {
    private Integer id;
    private String content;
    private Date date;
    private Integer eventId;
    private User user;

    public CommentOut(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.date = comment.getDate();
        this.eventId = comment.getEvent().getId();
        this.user = comment.getUser();
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

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
