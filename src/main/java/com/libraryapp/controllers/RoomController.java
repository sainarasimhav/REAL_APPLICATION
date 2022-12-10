package com.libraryapp.controllers;


import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Rooms;
import com.libraryapp.entities.User;
import com.libraryapp.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/rest/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/all")
    public List<Rooms> getRooms(){
        return roomService.findAll();
    }

    @GetMapping("/fetchbookedrooms{booked_date}")
    public List<BookedRoomsDto> getBookedRoomsInnerJoin(@PathVariable(value="booked_date") Date booked_date) {
//        return new ResponseEntity<List<BookedRoomsDto>>(roomService.getBookedRoomsInnerJoin(), HttpStatus.OK);
        List<BookedRoomsDto> bookedRoomsDtos = roomService.getBookedRoomsInnerJoin(booked_date);
        return bookedRoomsDtos;
    }
}
