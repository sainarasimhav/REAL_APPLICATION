package com.libraryapp.ids;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EventsIds implements Serializable {
    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    private long event_id;
    private long userId;

    public EventsIds(long event_id, long userId) {
        this.event_id = event_id;
        this.userId = userId;
    }

    public EventsIds(){};

}
