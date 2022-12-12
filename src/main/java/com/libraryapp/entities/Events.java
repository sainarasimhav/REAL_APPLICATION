package com.libraryapp.entities;

import com.libraryapp.ids.EventsIds;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity()
@Table(name = "EVENT")
@IdClass(EventsIds.class)
public class Events implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private long event_id;

    @Id
    @Column(name = "user_id")
    private long userId;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Column(name = "event_name")
    private String eventName;

    private String description;

    private Date start_date;

    private Date end_date;

    private String event_type;

//    public long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(long user_id) {
//        this.user_id = user_id;
//    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



//    @OneToMany(mappedBy = "reservedByEvents")
//    private List<EventsTopics> reservedByEventsTopics;

    public Events(){}


    public Events(long event_id, String eventName, String description, Date start_date, Date end_date, String event_type, long userId) {
        this.event_id = event_id;
        this.eventName = eventName;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.event_type = event_type;
        this.userId = userId;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

//    public String getEvent_name() {
//        return event_name;
//    }
//
//    public void setEvent_name(String event_name) {
//        this.event_name = event_name;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }
}