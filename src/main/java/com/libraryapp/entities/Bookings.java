package com.libraryapp.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity()
@Table(name = "BOOKINGS")

public class Bookings implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int booking_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    //    @Column(name = "customer_id")
    private int customer_id;

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    private int slot_id;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    private int room_id;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    private long user_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date booking_date;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY)
//    private Customers reservedByCustomers;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY)
//    private Slots reservedBySlots;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Customers customer;

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Slots slot;
    public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Rooms room;

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private User user;
//
//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.LAZY)
//    private Rooms room;

//    public Rooms getRoom_id() {
//        return room_id;
//    }
//
//    public void setRoom_id(Rooms room_id) {
//        this.room_id = room_id;
//    }
//
//    public Rooms getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(Rooms rooms) {
//        this.rooms = rooms;
//    }

    public Bookings(){}

    public Bookings(int booking_id, int room_id, int customer_id, int slot_id,   Date booking_date, long user_id) { //int room_id, int customer_id, int slot_id,
        this.booking_id = booking_id;
        this.customer_id = customer_id;
        this.slot_id = slot_id;
        this.room_id = room_id;
        this.booking_date = booking_date;
        this.user_id = user_id;
    }


//    public Customers getReservedByCustomers() {
//        return reservedByCustomers;
//    }
//
//    public void setReservedByCustomers(Customers reservedByCustomers) {
//        this.reservedByCustomers = reservedByCustomers;
//    }

//    public Slots getReservedBySlots() {
//        return reservedBySlots;
//    }
//
//    public void setReservedBySlots(Slots reservedBySlots) {
//        this.reservedBySlots = reservedBySlots;
//    }

//    public Rooms getReservedByRooms() {
//        return reservedByRooms;
//    }
//
//    public void setReservedByRooms(Rooms reservedByRooms) {
//        this.reservedByRooms = reservedByRooms;
//    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

//    public int getCustomer_id() {
//        return customer_id;
//    }
//
//    public void setCustomer_id(int customer_id) {
//        this.customer_id = customer_id;
//    }

//    public int getSlot_id() {
//        return slot_id;
//    }
//
//    public void setSlot_id(int slot_id) {
//        this.slot_id = slot_id;
//    }

//    public int getRoom_id() {
//        return room_id;
//    }
//
//    public void setRoom_id(int room_id) {
//        this.room_id = room_id;
//    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }
}
