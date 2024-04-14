package com.Event.EventEaze.Data.Repositories;

import com.Event.EventEaze.Data.Models.Ticket;
import com.Event.EventEaze.Data.Models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface TicketRepository extends JpaRepository <Ticket,Long> {
    Ticket findTicketByPurchaseDate(LocalDateTime purchaseDate);
    Ticket findTicketByTicketStatus(TicketStatus ticketStatus);
    
}
