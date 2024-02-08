package com.example.web_250.services.implementation;

import com.example.web_250.models.entities.Comment;
import com.example.web_250.models.entities.Event;
import com.example.web_250.models.entities.User;
import com.example.web_250.models.in.CommentIn;
import com.example.web_250.models.out.CommentOut;
import com.example.web_250.services.CommentService;
import com.example.web_250.services.EventService;
import com.example.web_250.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.web_250.repositories.CommentRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository _CommentRepository;

    @Autowired
    private EventService _EventService;

    @Autowired
    private UserService _UserService;

    @Override
    public List<CommentOut> getCommentsForEvent(int eventId) {
        return  _CommentRepository.findAll().stream().filter(c -> c.getEvent().getId() == eventId).map(CommentOut::new).collect(Collectors.toList());
    }

    @Override
    public void setCommentForEvent(int eventId, CommentIn comment) {
        if(comment == null) throw new IllegalArgumentException("Comment is null");
        Event event = _EventService.getEventByIdForComment(eventId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = _UserService.getUserByEmail(userEmail);
        Comment temp = new Comment(comment);
        temp.setEvent(event);
        temp.setUser(user);
        temp.setDate(new Date());
        _CommentRepository.save(temp);
    }
}
