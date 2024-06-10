package com.Event.EventEaze.Data.Repositories;

import com.Event.EventEaze.Data.Models.Ticket;
import com.Event.EventEaze.Data.Models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

public interface TicketRepository extends JpaRepository <Ticket,Long> {
    Ticket findTicketByEventName(String eventName);

    
}
