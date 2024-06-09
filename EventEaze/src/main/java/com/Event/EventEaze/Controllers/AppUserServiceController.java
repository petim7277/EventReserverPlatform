package com.Event.EventEaze.Controllers;

import com.Event.EventEaze.Dtos.Requests.LoginRequest;
import com.Event.EventEaze.Dtos.Requests.RegisterRequest;
import com.Event.EventEaze.Dtos.Responses.LoginResponse;
import com.Event.EventEaze.Dtos.Responses.RegisterResponse;
import com.Event.EventEaze.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/UserController/")
public class AppUserServiceController {
    private final UserService userService;
    @PostMapping("registration")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest){
       RegisterResponse response = userService.register(registerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("logging in")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        LoginResponse response = userService.login(loginRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
//    @GetMapping("{/ids}")
//    public ResponseEntity<EventResponse> getAllEvents() {
//        return new ResponseEntity<>();
//    }
}
