package com.libraryapp.controllers;


import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Book;
import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Rooms;
import com.libraryapp.entities.User;
import com.libraryapp.security.CurrentUserFinder;
import com.libraryapp.services.RoomService;
import com.libraryapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    CurrentUserFinder currentUserFinder;
    @Autowired
    UserService usService;

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
    public ModelAndView getBookedRoomsInnerJoin(@RequestParam(value = "selectedDate",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date selectedDate,
                                                @RequestParam(value = "selectedDate",required = false) String date1,
                                                Model model)  { //@PathVariable(value="booked_date") Date booked_date //pattern="yyyy-MM-dd"
//        return new ResponseEntity<List<BookedRoomsDto>>(roomService.getBookedRoomsInnerJoin(), HttpStatus.OK);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
//        Date selectedDate = formatter.parse(date);
//        Date date1=@DateTimeFormat(pattern="MM-dd-yyyy") date;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room/user-rent-study.html");

        if(selectedDate!=null){
            List<BookedRoomsDto> bookedRoomsDtos = roomService.getBookedRoomsInnerJoin(selectedDate);
            model.addAttribute("bookedRooms",bookedRoomsDtos);
        }
        //booked_date

        List<Rooms> rooms=getRooms();

        model.addAttribute("selectedDate",date1);
        model.addAttribute("rooms",rooms);
//        model.addAttribute("date1",date1);


//        model.addAttribute("room_id",bookedRoomsDtos.get(0).getRoom_id())
//        System.out.println(model.getAttribute("bookedRooms"));
//        System.out.println("Input from site: "+date);
//        return bookedRoomsDtos;
        return modelAndView;
//        return "/room/room-rent-study.html";
    }

    @GetMapping(value = "/addrooms")
    public ModelAndView loadaddroom(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room/admin-add-room.html");
        return modelAndView;
    }

    @GetMapping("/newroom")
    @ResponseBody
    public ModelAndView saveRooms(@RequestParam(value = "roomid") int roomid,
                                    @RequestParam(value = "capacity",required = false) int capacity,
                                    Model model)  {
        Rooms room = new Rooms();
        room.setRoom_id(roomid);
        room.setCapacity(capacity);
        ModelAndView modelAndView = new ModelAndView();
        roomService.save(room);
        modelAndView.setViewName("room/admin-room-success.html");
        return modelAndView;
    }
    @GetMapping(value = "/addSuccess")
    public ModelAndView addSuccess(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("room/admin-add-room.html");
        return modelAndView;
    }

}