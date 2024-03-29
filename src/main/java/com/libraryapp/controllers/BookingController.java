package com.libraryapp.controllers;

import com.libraryapp.entities.Bookings;
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
    public List<Bookings> getBookings(){
        return bookingService.findAll();
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

        return modelAndView;
    }
}
