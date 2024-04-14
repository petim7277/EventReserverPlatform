package com.Event.EventEaze.Services;
import com.Event.EventEaze.Dtos.Requests.*;
import com.Event.EventEaze.Dtos.Responses.EventResponse;
import com.Event.EventEaze.Dtos.Responses.LoginResponse;
import com.Event.EventEaze.Dtos.Responses.RegisterResponse;
import com.Event.EventEaze.Dtos.Responses.TicketReservationResponse;
import com.Event.EventEaze.Dtos.TicketResponse;

public interface AdminService {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    TicketResponse createTicket(TicketRequest ticketRequest);
    TicketResponse  removeTicket(TicketRemoveRequest ticketRequest);
    EventResponse    createEvents(EventRequest eventRequest);
    EventResponse removeEvents(EventRemoveRequest eventRequest);
    TicketReservationResponse reserveTicket(TicketReservationRequest ticketRequest);
    void notifyUser(UserNotificationRequest notificationRequest);
}
