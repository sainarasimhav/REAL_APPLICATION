package com.libraryapp.services;

import com.libraryapp.DAO.RoomRepository;
import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

@Service
public class RoomService {
    @Autowired
    RoomRepository rmRepo;

    public List<Rooms> findAll(){
        return (List<Rooms>) rmRepo.findAll();
    }

    public List<BookedRoomsDto> getBookedRoomsInnerJoin(Date booked_date) {
        List<BookedRoomsDto> bookedRoomsDtos = rmRepo.fetchBookedRoomsDataInnerJoin(booked_date);
        bookedRoomsDtos.forEach(l -> System.out.println(l));
        return bookedRoomsDtos;
    }

}
