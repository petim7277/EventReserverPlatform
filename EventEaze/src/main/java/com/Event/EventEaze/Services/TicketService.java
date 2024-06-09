package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.Ticket;
import com.Event.EventEaze.Dtos.Requests.TicketRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Dtos.Requests.TicketReservationRequest;
import com.Event.EventEaze.Dtos.Responses.TicketReservationResponse;
import com.Event.EventEaze.Dtos.Responses.TicketResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TicketService {
    TicketResponse createTicket(TicketRequest ticketRequest);
    Optional<Ticket> findTicket (Long id);
    TicketResponse removeTicket(TicketRemoveRequest ticketRequest);
    TicketReservationResponse reserveTicket(TicketReservationRequest ticketRequest);
}
