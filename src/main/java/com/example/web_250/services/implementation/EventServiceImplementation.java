package com.example.web_250.services.implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.web_250.models.entities.Category;
import com.example.web_250.models.entities.Event;
import com.example.web_250.models.in.EventIn;
import com.example.web_250.models.out.EventOut;
import com.example.web_250.repositories.CategoryRepository;
import com.example.web_250.repositories.EventRepository;
import com.example.web_250.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImplementation implements EventService {

    @Autowired 
    private EventRepository _EventRepository;

    @Autowired
    private CategoryRepository _CategoryRepository;


    @Override
    public List<EventOut> getAllEvents() {
        return _EventRepository.findAll().stream().filter(e -> e.getDate().compareTo(new Date()) > 0).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public List<EventOut> getAllEventsByName(String name) {
        return _EventRepository.findAll().stream().filter(e -> e.getName().equals(name)).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public List<EventOut> getAllEventsByCategory(int id) {
        return _EventRepository.findAll().stream().filter(e -> e.getCategory().getId() == id && e.getDate().compareTo(new Date()) > 0).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public EventOut getEventById(int id) {
        try {
            if(_EventRepository.findById(id) == null) throw new Exception("Event did not found.");
            return new EventOut(_EventRepository.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Event getEventByIdForComment(int id) {
        try {
            if(_EventRepository.findById(id) == null) throw new Exception("Event did not found.");
            return _EventRepository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public EventOut addNewEvent(EventIn event) {
        Event temp = new Event(event);
        List<Category> categories = _CategoryRepository.findById(event.getCategoryId()).stream().collect(Collectors.toList());
        if (categories.isEmpty()) {
            throw new IllegalArgumentException("Invalid data");
        }
        temp.setCategory(categories.get(0));
        _EventRepository.save(temp);
        return new EventOut(temp);
    }

    @Override
    public EventOut editEvent(EventIn event) {
        Event temp = new Event(event);
        List<Category> categories = _CategoryRepository.findById(event.getCategoryId()).stream().collect(Collectors.toList());
        if (categories.isEmpty()) {
            throw new IllegalArgumentException("Invalid data");
        }
        temp.setCategory(categories.get(0));

        _EventRepository.save(temp);
        return new EventOut(temp);
    }
}
