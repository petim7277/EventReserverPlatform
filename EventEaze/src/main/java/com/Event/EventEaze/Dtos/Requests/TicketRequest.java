package com.Event.EventEaze.Dtos.Requests;
import com.Event.EventEaze.Data.Models.Gender;
import com.Event.EventEaze.Data.Models.TicketCategory;
import com.Event.EventEaze.Data.Models.TicketStatus;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class TicketRequest {
      private String eventName;
      private String eventDate;


}
