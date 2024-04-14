package com.Event.EventEaze.Dtos.Requests;

import com.Event.EventEaze.Data.Models.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
 @Setter
 @Getter
public class TicketRemoveRequest {
    private LocalDate purchaseDate;
    private TicketStatus ticketStatus;
 }
