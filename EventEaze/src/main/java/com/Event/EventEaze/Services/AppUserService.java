package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.User;
import com.Event.EventEaze.Data.Repositories.UserRepository;
import com.Event.EventEaze.Dtos.Requests.EventRequest;
import com.Event.EventEaze.Dtos.Requests.LoginRequest;
import com.Event.EventEaze.Dtos.Requests.RegisterRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Dtos.Responses.EventResponse;
import com.Event.EventEaze.Dtos.Responses.LoginResponse;
import com.Event.EventEaze.Dtos.Responses.RegisterResponse;
import com.Event.EventEaze.Dtos.TicketResponse;
import com.Event.EventEaze.Exceptions.InvalidFieldsException;
import com.Event.EventEaze.Exceptions.UserExistException;
import com.Event.EventEaze.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.Event.EventEaze.Utills.Validator.*;

@Service
@AllArgsConstructor
public class AppUserService implements UserService {
     private final UserRepository userRepository;

    @Override
    public RegisterResponse register(@Valid RegisterRequest registerRequest) {
      RegisterResponse response = new RegisterResponse();
      ModelMapper mapper = new ModelMapper();
       User foundUser =  userRepository.findByEmail(registerRequest.getEmail());
       if (foundUser != null){
           throw new UserExistException("User already exist") ;   }
        foundUser = mapper.map(registerRequest,User.class);
        validateRequest(registerRequest);
       userRepository.save(foundUser);
       response.setMessage("Registration successful");
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();
        User foundUser = userRepository.findByEmail(loginRequest.getEmail());
        if (foundUser == null){
            throw  new UserNotFoundException("user not found");
        }
        response.setMessage("User has been successfully logged in");
        return response;
    }

    @Override
    public TicketResponse viewTicket(TicketRequest ticketRequest) {
        return null;
    }

    @Override
    public EventResponse viewEvent(EventRequest eventRequest) {
        return null;
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByName(username);
    }

//    @Override
//    public TicketResponse findTicket(TicketRequest ticketRequest) {
//        return null;
//    }

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

    public Optional<User> findUser(Long id){
        return userRepository.findById(id);
    }
}
