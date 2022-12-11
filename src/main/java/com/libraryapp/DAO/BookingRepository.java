package com.libraryapp.DAO;

import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Rooms;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Bookings, Long> {
}
