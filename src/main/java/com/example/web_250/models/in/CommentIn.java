package com.example.web_250.models.in;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;

public class CommentIn {
    @Nullable
    private Integer id;
    private Integer eventId;
    private String userEmail;
    private String date;
    @Size(max = 1000)
    private String content;

    public CommentIn(@Nullable Integer id, Integer eventId, String userEmail, String date, String content) {
        this.id = id;
        this.eventId = eventId;
        this.userEmail = userEmail;
        this.date = date;
        this.content = content;
    }

    @Nullable
    public Integer getId() {
        return this.id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
