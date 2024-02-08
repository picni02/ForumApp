package com.example.web_250.services;

import com.example.web_250.models.in.CommentIn;
import com.example.web_250.models.out.CommentOut;

import java.util.List;

public interface CommentService {
    public List<CommentOut> getCommentsForEvent(int eventId);
    public void setCommentForEvent(int eventId, CommentIn comment);
}
