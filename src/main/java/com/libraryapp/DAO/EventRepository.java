package com.libraryapp.DAO;

import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Events, Long> {
    List<Events> findByUserId(long userId);

    List<Events> findByEventNameContaining(String userName);
}
