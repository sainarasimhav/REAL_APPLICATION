package com.libraryapp.controllers;


import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Rooms;
import com.libraryapp.entities.User;
import com.libraryapp.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value="/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/showrooms")
    public ModelAndView showrooms(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room/user-rent-study.html");
        return modelAndView;
    }
    @GetMapping("/all")
    public List<Rooms> getRooms(){
        return roomService.findAll();
    }
//public List<BookedRoomsDto> getBookedRoomsInnerJoin(@PathVariable(value="booked_date") Date booked_date) {
    @GetMapping("/fetchbookedrooms")
    @ResponseBody
    public List<BookedRoomsDto> getBookedRoomsInnerJoin(@RequestParam String date) throws ParseException { //@PathVariable(value="booked_date") Date booked_date
//        return new ResponseEntity<List<BookedRoomsDto>>(roomService.getBookedRoomsInnerJoin(), HttpStatus.OK);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date selectedDate = formatter.parse(date);
        List<BookedRoomsDto> bookedRoomsDtos = roomService.getBookedRoomsInnerJoin(selectedDate); //booked_date
        return bookedRoomsDtos;
//        return "/room/room-rent-study.html";
    }
}
