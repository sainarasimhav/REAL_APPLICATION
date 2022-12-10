package com.libraryapp.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity()
@Table(name = "SLOTS")

public class Slots {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long slot_id;

    @Column(name = "slot_range")
    private String slot_range;

    @OneToMany(mappedBy = "reservedBySlots")
    private List<Bookings> reservedByBookings;

    public Slots(){}


    public Slots(long slot_id, String slot_range, List<Bookings> reservedByBookings) {
        this.slot_id = slot_id;
        this.slot_range = slot_range;
        this.reservedByBookings = reservedByBookings;
    }

    public long getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(long slot_id) {
        this.slot_id = slot_id;
    }

    public String getSlot_range() {
        return slot_range;
    }

    public void setSlot_range(String slot_range) {
        this.slot_range = slot_range;
    }

    public List<Bookings> getReservedByBookings() {
        return reservedByBookings;
    }

    public void setReservedByBookings(List<Bookings> reservedByBookings) {
        this.reservedByBookings = reservedByBookings;
    }
}
