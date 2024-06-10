package com.Event.EventEaze.Services;
import com.Event.EventEaze.Data.Models.Event;
import com.Event.EventEaze.Data.Models.Ticket;
import com.Event.EventEaze.Data.Models.TicketStatus;
import com.Event.EventEaze.Data.Repositories.EventRepository;
import com.Event.EventEaze.Data.Repositories.TicketRepository;
import com.Event.EventEaze.Dtos.Requests.TicketRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Dtos.Requests.TicketReservationRequest;
import com.Event.EventEaze.Dtos.Responses.TicketReservationResponse;
import com.Event.EventEaze.Dtos.Responses.TicketResponse;
import com.Event.EventEaze.Exceptions.EventNotFoundException;
import com.Event.EventEaze.Exceptions.TicketNotFoundException;
import com.Event.EventEaze.Exceptions.TicketStatusException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AppTicketService  implements  TicketService{
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private  final  EventService eventService;
    private  final UserService userService;

    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        TicketResponse response = new TicketResponse();
        ModelMapper mapper = new ModelMapper();
        Event foundEvent = eventRepository.findByEventName(ticketRequest.getEventName()) ;
        if (foundEvent == null){throw  new EventNotFoundException("Event Does not exist");}
        Ticket createdTicket = mapper.map(ticketRequest, Ticket.class);
        ticketRepository.save(createdTicket) ;
        response.setMessage("Ticket successfully created");
        return response;
    }


    @Override
    public Optional<Ticket> findTicket(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public TicketResponse removeTicket(TicketRemoveRequest ticketRequest) {
        ModelMapper mapper = new ModelMapper();
        TicketResponse response = new TicketResponse();
        Ticket foundTicket  = ticketRepository.findTicketByEventName(ticketRequest.getEventName()) ;
        if (foundTicket == null)
            throw  new TicketNotFoundException("Ticket does not  exist") ;
        foundTicket = mapper.map(ticketRequest, Ticket.class);
        ticketRepository.delete(foundTicket);   
        response.setMessage("Ticket successfully removed");
        return response;

    }

    @Override
    public TicketReservationResponse reserveTicket(TicketReservationRequest ticketRequest) {
        ModelMapper mapper  = new ModelMapper();
        TicketReservationResponse response = new TicketReservationResponse();
        Ticket foundTicket = ticketRepository.findTicketByEventName(ticketRequest.getEventName());
        if (foundTicket == null)
            throw  new TicketNotFoundException("Ticket does not exist") ;
        foundTicket = mapper.map(ticketRequest,Ticket.class);
            ticketRepository.save(foundTicket) ;
        response.setResponse("Ticket reservation successful");
        return response;
    }


}
