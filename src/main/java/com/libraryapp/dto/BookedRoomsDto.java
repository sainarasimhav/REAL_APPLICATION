package com.libraryapp.dto;

import java.io.Serializable;

public class BookedRoomsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int room_id =0;
    private int capacity=0;
    private int slot_id =0;

    public BookedRoomsDto(int room_id, int capacity, int slot_id) {
        this.room_id = room_id;
        this.capacity = capacity;
        this.slot_id = slot_id;
    }

    @Override
    public String toString() {
        return "BookedRoomsDto [room_id=" + room_id + ", capacity=" + capacity + ", slot_id=" + slot_id + "]";
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

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }
}
