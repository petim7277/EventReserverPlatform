package com.Event.EventEaze.Dtos.Requests;

import com.Event.EventEaze.Data.Models.Gender;
import com.Event.EventEaze.Data.Models.TicketStatus;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TicketReservationRequest {
    private String eventName;
    private String username;
    private Gender gender;
}
