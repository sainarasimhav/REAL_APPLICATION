package com.libraryapp.DAO;

import com.libraryapp.dto.BookedRoomsDto;
import com.libraryapp.entities.Rooms;
import com.libraryapp.entities.Bookings;
import com.libraryapp.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Date;

@Repository
public interface RoomRepository extends CrudRepository<Rooms, Long> {
    @Query("SELECT new com.libraryapp.dto.BookedRoomsDto(r.room_id, r.capacity, b.slot_id) "
            + "FROM Rooms r INNER JOIN r.book b")
    List<BookedRoomsDto> fetchBookedRoomsDataInnerJoin(Date booked_date);
}
