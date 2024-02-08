package com.example.web_250.services;

import java.util.List;

import com.example.web_250.models.entities.Event;
import com.example.web_250.models.in.EventIn;
import com.example.web_250.models.out.EventOut;

public interface EventService {
    public List<EventOut> getAllEvents();
    public List<EventOut> getAllEventsByName(String name);
    public List<EventOut> getAllEventsByCategory(int id);
    public EventOut getEventById(int id);
    public Event getEventByIdForComment(int id);
    public EventOut addNewEvent(EventIn event);
    public EventOut editEvent(EventIn event);
}
