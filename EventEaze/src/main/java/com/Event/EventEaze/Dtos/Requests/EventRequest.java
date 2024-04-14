package com.Event.EventEaze.Dtos.Requests;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;@Setter
@Getter
public class EventRequest {

    private String eventName;
    private LocalDate eventDate ;
    private Integer availableAttendees;
    private String eventVenue;
    private String eventDescription;
    
}
