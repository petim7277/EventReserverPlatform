package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.User;
import com.Event.EventEaze.Dtos.Requests.EventRequest;
import com.Event.EventEaze.Dtos.Requests.LoginRequest;
import com.Event.EventEaze.Dtos.Requests.RegisterRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Dtos.Responses.EventResponse;
import com.Event.EventEaze.Dtos.Responses.LoginResponse;
import com.Event.EventEaze.Dtos.Responses.RegisterResponse;
import com.Event.EventEaze.Dtos.Responses.TicketResponse;

public interface UserService {
  RegisterResponse register(RegisterRequest registerRequest);
  LoginResponse login(LoginRequest loginRequest);
  TicketResponse viewTicket (TicketRequest ticketRequest);
  EventResponse  viewReservations(EventRequest eventRequest);
  User findUser(String username);

}
