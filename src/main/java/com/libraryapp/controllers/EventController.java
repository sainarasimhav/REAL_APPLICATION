package com.libraryapp.controllers;

import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Events;
import com.libraryapp.entities.User;
import com.libraryapp.security.CurrentUserFinder;
import com.libraryapp.services.EventService;
import com.libraryapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/showregisteredevents")
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
            List<Events> eventsall = eventService.findByEventNameContaining(eventName);
            List<Events> events = new ArrayList<>();
            for (Events e:eventsall) {
                if(e.getUserId() == 1){
                    events.add(e);
                }
            }
            long currentUserId = currentUserFinder.getCurrentUserId();
            User currentUser = usService.findById(currentUserId);
            List<Events> eventsByUserId = eventService.findByUserId(currentUser.getUserId());
            model.addAttribute("events",events);
            model.addAttribute("eventsByUserId",eventsByUserId);
        }
        return modelAndView;
    }

    @GetMapping("/registerevents")
    @ResponseBody
    public ModelAndView saveEvents(@RequestParam(value = "eventId",required = false) int eventId,
                                   @RequestParam(value = "eventName",required = false) String eventName,
                                   @RequestParam(value = "start_date",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date start_date,
                                   @RequestParam(value = "end_date",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date end_date,
                                   @RequestParam(value = "event_type", required = false) String event_type,
                                   @RequestParam(value = "description", required = false) String description,
                                   Model model){
        ModelAndView modelAndView = new ModelAndView();
        long currentUserId = currentUserFinder.getCurrentUserId();
        User currentUser = usService.findById(currentUserId);
        Events events = new Events();
        events.setEvent_id(eventId);
        events.setEventName(eventName);
        events.setStart_date(start_date);
        events.setEnd_date(end_date);
        events.setEvent_type(event_type);
        events.setDescription(description);
        events.setUserId(currentUser.getUserId());
        eventService.save(events);
        modelAndView.setViewName("event/user-event-register-success.html");
        return modelAndView;
    }

    @GetMapping(value="/yourevents")
    public ModelAndView yourEvents(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("event/user-event-your-events.html");
        long currentUserId = currentUserFinder.getCurrentUserId();
        User currentUser = usService.findById(currentUserId);
        List<Events> eventsByUserId = eventService.findByUserId(currentUser.getUserId());
        model.addAttribute("eventsByUserId", eventsByUserId);
        return modelAndView;
    }

    @GetMapping(value="/addevent")
    public ModelAndView addEvents(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("event/employee-add-event.html");
        return modelAndView;
    }

    @GetMapping(value="/saveevent")
    @ResponseBody
    public ModelAndView saveAddedEvents(@RequestParam(value = "eventId") int eventId,
                                   @RequestParam(value = "eventName",required = false) String eventName,
                                   @RequestParam(value = "start_date",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date start_date,
                                   @RequestParam(value = "end_date",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date end_date,
                                   @RequestParam(value = "event_type", required = false) String event_type,
                                   @RequestParam(value = "description", required = false) String description,
                                    Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Events events = new Events();
        events.setEvent_id(eventId);
        events.setEventName(eventName);
        events.setStart_date(start_date);
        events.setEnd_date(end_date);
        events.setEvent_type(event_type);
        events.setDescription(description);
        events.setUserId(1);
        eventService.save(events);
        modelAndView.setViewName("event/employee-event-success.html");
        return modelAndView;
    }

    @PutMapping(value="/payreservation")
    public String payReservation(@RequestParam Double amountToPay,
                                 Model model) {

        model.addAttribute("amountToPay", amountToPay);
//        model.addAttribute("reservedBookIdsInString", reservedBookIdsInString);
        return "user/user-pay-reservation.html";
    }
}
