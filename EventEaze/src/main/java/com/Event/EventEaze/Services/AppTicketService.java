package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.Ticket;
import com.Event.EventEaze.Data.Models.TicketStatus;
import com.Event.EventEaze.Data.Models.User;
import com.Event.EventEaze.Data.Repositories.TicketRepository;
import com.Event.EventEaze.Dtos.Requests.TicketRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Dtos.Requests.TicketReservationRequest;
import com.Event.EventEaze.Dtos.Responses.TicketReservationResponse;
import com.Event.EventEaze.Dtos.TicketResponse;
//import com.Event.EventEaze.Exceptions.EventNotFoundException;
import com.Event.EventEaze.Exceptions.TicketNotFoundException;
//import com.Event.EventEaze.Exceptions.TicketStatusEception;
import com.Event.EventEaze.Exceptions.TicketStatusException;
import com.Event.EventEaze.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AppTicketService  implements  TicketService{
    private final TicketRepository ticketRepository;
    private  final  EventService eventService;
    private  final UserService userService;
    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        TicketResponse response = new TicketResponse();
        checkTicketDetails(ticketRequest);
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
        Ticket foundTicket  = ticketRepository.findTicketByPurchaseDate
                (ticketRequest.getPurchaseDate().atStartOfDay());
        if (foundTicket != null)
            throw  new TicketNotFoundException("Ticket already  exist") ;
        foundTicket = mapper.map(ticketRequest, Ticket.class);
        if (ticketRequest.getTicketStatus().equals(TicketStatus.CANCELLED)){
        ticketRepository.delete(foundTicket);   }
        response.setMessage("Ticket successfully removed");
        return response;

    }

    @Override
    public TicketReservationResponse reserveTicket(TicketReservationRequest ticketRequest) {
        ModelMapper mapper  = new ModelMapper();
        TicketReservationResponse response = new TicketReservationResponse();
        Ticket foundTicket = ticketRepository.findTicketByTicketStatus(ticketRequest.getTicketStatus());
        if (foundTicket == null)
            throw  new TicketNotFoundException("Ticket does not exist") ;
        foundTicket = mapper.map(ticketRequest,Ticket.class);
        if (ticketRequest.getTicketStatus().equals(TicketStatus.PENDING)) {
            ticketRepository.save(foundTicket) ;
        }
        else throw new TicketStatusException("Ticket status is invalid");
        response.setResponse("Ticket reservation successful");
        return response;
    }

    public void checkTicketDetails(TicketRequest ticketRequest){
        ModelMapper mapper = new ModelMapper();
        TicketResponse response = new TicketResponse();
        User foundUser =  userService.findUser(ticketRequest.getUsername());
        if (foundUser == null)
            throw  new UserNotFoundException("User does not exist");
        Ticket foundTicket  = ticketRepository.findTicketByPurchaseDate
                (ticketRequest.getPurchaseDate().atStartOfDay());
        if (foundTicket != null)
            throw  new TicketNotFoundException("Ticket already  exist") ;
        foundTicket = mapper.map(ticketRequest, Ticket.class);
        if (ticketRequest.getTicketStatus().equals(TicketStatus.CONFIRMED)) {
            ticketRepository.save(foundTicket);  }
    }
}
