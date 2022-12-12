package com.libraryapp.services;

import com.libraryapp.DAO.BookingRepository;
import com.libraryapp.entities.Book;
import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Events;
import com.libraryapp.entities.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bkRepo;

    public List<Bookings> findAll(){
        return (List<Bookings>) bkRepo.findAll();
    }

    public void save(Bookings booking) {
        bkRepo.save(booking);
    }

    public List<Bookings> findByUserId(long userId) {
        return (List<Bookings>) bkRepo.findByUserId(userId);
    }
}
