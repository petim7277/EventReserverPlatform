package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.Admin;
import com.Event.EventEaze.Data.Models.Event;
import com.Event.EventEaze.Data.Models.User;
import com.Event.EventEaze.Data.Repositories.AdminRepository;
import com.Event.EventEaze.Data.Repositories.EventRepository;
import com.Event.EventEaze.Dtos.Requests.*;
import com.Event.EventEaze.Dtos.Responses.*;
import com.Event.EventEaze.Dtos.TicketResponse;
import com.Event.EventEaze.Exceptions.EventNotFoundException;
import com.Event.EventEaze.Exceptions.InvalidFieldsException;
import com.Event.EventEaze.Exceptions.UserExistException;
import com.Event.EventEaze.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.Event.EventEaze.Utills.Validator.*;

@AllArgsConstructor
@Service
public class AppAdminService implements AdminService {
    private  final AdminRepository adminRepository;
    private final AppEventService eventService;
    private  final AppTicketService ticketService;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        RegisterResponse response = new RegisterResponse();
        ModelMapper mapper = new ModelMapper();
        Admin foundUser =  adminRepository.findByEmail(registerRequest.getEmail());
        if (foundUser != null){
            throw new UserExistException("User already exist") ;   }
        foundUser = mapper.map(registerRequest,Admin.class);
        validateRequest(registerRequest);
        adminRepository.save(foundUser);
        response.setMessage("Registration successful");
        return response;

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();
        Admin foundUser = adminRepository.findByEmail(loginRequest.getEmail());
        if (foundUser == null){
            throw  new UserNotFoundException("user not found");
        }
        response.setMessage("User has been successfully logged in");
        return response;
    }

    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        return ticketService.createTicket(ticketRequest);
    }

    @Override
    public TicketResponse removeTicket(TicketRemoveRequest ticketRequest) {
        return ticketService.removeTicket(ticketRequest);
    }

    @Override
    public EventResponse createEvents(EventRequest eventRequest) {
                return eventService.createEvent(eventRequest) ;
    }

    @Override
    public EventResponse removeEvents(EventRemoveRequest eventRequest) {
        return eventService.removeEvent(eventRequest);
    }

    @Override
    public TicketReservationResponse reserveTicket(TicketReservationRequest ticketRequest) {
        
        return null;
    }

    @Override
    public void notifyUser(UserNotificationRequest notificationRequest) {

    }

    public void validateRequest (RegisterRequest request){

        if (!validateName(request.getName()) || request.getEmail().trim().isEmpty())  {
            throw  new InvalidFieldsException("username must be of 6 to 12 length with no special characters") ;
        }
        if (!validatePassword(request.getPassword()) || request.getEmail().trim().isEmpty()){
            throw  new InvalidFieldsException("password must be min 4 and max 12 length containing at least 1" +
                    " uppercase, 1 lowercase, 1 special character and 1 digit ") ;
        }
        if (!validateEmail(request.getEmail()) || request.getEmail().trim().isEmpty()){
            throw new InvalidFieldsException("Invalid email format. Please use the format user@example.com");
        }


    }
}
