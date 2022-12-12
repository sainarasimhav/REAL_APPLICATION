package com.libraryapp.controllers;

import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Events;
import com.libraryapp.entities.Rooms;
import com.libraryapp.entities.User;
import com.libraryapp.security.CurrentUserFinder;
import com.libraryapp.services.BookingService;
import com.libraryapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    CurrentUserFinder currentUserFinder;
    @Autowired
    UserService usService;

    @GetMapping("/all")
    @ResponseBody
    public List<Bookings> getBookings(){
        return bookingService.findAll();
    }

    @GetMapping("/allusers")
    @ResponseBody
    public int [] getAllUsers(Model model){
        List<User> users = usService.findAll();

        int []counts = new int[]{0,0,0};
        for (User u:users) {
            if(u.getRole().contains("ROLE_USER")){
                counts[0]++;
            }
            if(u.getRole().contains("ROLE_ADMIN")){
                counts[1]++;
            }
            if(u.getRole().contains("ROLE_EMPLOYEE")){
                counts[2]++;
            }
        }
        model.addAttribute("counts",counts);
        return counts;
    }

    @GetMapping("/yourrooms")
    @ResponseBody
    public List<Bookings> getBookedRooms(){
        long currentUserId = currentUserFinder.getCurrentUserId();
        User currentUser = usService.findById(currentUserId);
        List<Bookings> bookings = bookingService.findByUserId(currentUser.getUserId());
        return bookings;
    }

    @GetMapping("/selectedRooms")
    @ResponseBody
    public ModelAndView saveBookings(@RequestParam(value = "date",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date selectedDate,
                                                @RequestParam(value = "check",required = false) int slot_id,
                                                @RequestParam(value = "roomId",required = false) int room_id,
                                                Model model)  {
        long currentUserId = currentUserFinder.getCurrentUserId();
        User currentUser = usService.findById(currentUserId);
        Bookings booking = new Bookings();
        booking.setRoom_id(room_id);
        booking.setSlot_id(slot_id);
        booking.setUser_id(currentUser.getUserId());
        booking.setBooking_date(selectedDate);
        booking.setCustomer_id(101);
        ModelAndView modelAndView = new ModelAndView();
        bookingService.save(booking);
        modelAndView.setViewName("room/user-rent-success.html");
        return modelAndView;
    }

    @GetMapping("/yourbookedrooms")
    @ResponseBody
    public ModelAndView getBookedRooms(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room/user-room-bookings.html");
        long currentUserId = currentUserFinder.getCurrentUserId();
        User currentUser = usService.findById(currentUserId);
        List<Bookings> bookings = bookingService.findByUserId(currentUser.getUserId());
        model.addAttribute("bookings",bookings);
        System.out.println(bookings);
        return modelAndView;
    }

}
