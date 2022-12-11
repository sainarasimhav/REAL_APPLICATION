package com.libraryapp.controllers;

import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Events;
import com.libraryapp.entities.User;
import com.libraryapp.security.CurrentUserFinder;
import com.libraryapp.services.EventService;
import com.libraryapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value="/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    CurrentUserFinder currentUserFinder;
    @Autowired
    UserService usService;

    @GetMapping("/all")
    public List<Events> getEvents(){
        return eventService.findAll();
    }

    @GetMapping("/testing")
    @ResponseBody
    public List<Events> getBookedEvents(){
        long currentUserId = currentUserFinder.getCurrentUserId();
        User currentUser = usService.findById(currentUserId);
        List<Events> events = eventService.findByUserId(currentUser.getUserId());
        return events;
    }

    @GetMapping("/bynames")
    @ResponseBody
    public List<Events> getBookedEventsbyNames(@RequestParam(value = "eventname",required = false) String eventName){
        List<Events> events = eventService.findByEventNameContaining(eventName);
        return events;
    }

    @GetMapping("/showevents")
    @ResponseBody
    public ModelAndView showEvents(@RequestParam(value = "eventname",required = false) String eventName,
                                   Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("event/user-event-register.html");
        model.addAttribute("eventname",eventName);
        if(eventName!=null){
            List<Events> events = eventService.findByEventNameContaining(eventName);
            long currentUserId = currentUserFinder.getCurrentUserId();
            User currentUser = usService.findById(currentUserId);
            List<Events> eventsByUserId = eventService.findByUserId(currentUser.getUserId());
            model.addAttribute("events",events);
            model.addAttribute("eventsByUserId",eventsByUserId);
        }
        return modelAndView;
    }
}
