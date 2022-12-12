package com.libraryapp.services;

import com.libraryapp.DAO.EventRepository;
import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository evRepo;

    public List<Events> findAll(){
        return (List<Events>) evRepo.findAll();
    }

    public List<Events> findByUserId(long userId) {
        return (List<Events>) evRepo.findByUserId(userId);
    }

    public List<Events> findByEventNameContaining(String eventName) {
        return (List<Events>) evRepo.findByEventNameContaining(eventName);
    }

    public void save(Events events) {
        evRepo.save(events);
    }

}
