package com.libraryapp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity()
@Table(name = "ROOMS")

public class Rooms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int room_id;

    private int capacity;

//    @OneToMany(mappedBy = "room")
//    private List<Bookings> reservedByBookings;
    @OneToMany(targetEntity = Bookings.class, mappedBy = "room", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Bookings> book;

    public Rooms(){}


    public Rooms(int room_id, int capacity) {
        this.room_id = room_id;
        this.capacity = capacity;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

//    public List<Bookings> getReservedByBookings() {
//        return reservedByBookings;
//    }
//
//    public void setReservedByBookings(List<Bookings> reservedByBookings) {
//        this.reservedByBookings = reservedByBookings;
//    }
}
