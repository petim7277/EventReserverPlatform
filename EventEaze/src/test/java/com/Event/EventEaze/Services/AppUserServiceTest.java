package com.Event.EventEaze.Services;
import com.Event.EventEaze.Data.Models.Gender;
import com.Event.EventEaze.Data.Models.User;
import com.Event.EventEaze.Data.Repositories.UserRepository;
import com.Event.EventEaze.Dtos.Requests.LoginRequest;
import com.Event.EventEaze.Dtos.Requests.RegisterRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Exceptions.InvalidFieldsException;
import com.Event.EventEaze.Exceptions.UserNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
 @SpringBootTest
class AppUserServiceTest {
     @Autowired
     private UserRepository  userRepository;
     @Autowired
     private UserService  userService;

//     @BeforeEach
//     public  void deleteData(){
//         userRepository.deleteAll();
//     }
//     @AfterEach
//     public  void deleteAllData(){
//         userRepository.deleteAll();
//     }

     @Test
     public void Registration_WithWrongUsername_FieldTest(){
         RegisterRequest request = new RegisterRequest();
         request.setName("jo");
         request.setPassword("Jo_mie8");
         request.setEmail("jobs@gmail.com");
         request.setGender(Gender.FEMALE);
         assertThrows(InvalidFieldsException.class,()->userService.register(request));

     }
     @Test
     public void Registration_WithWrongPassword_FieldTest(){
         RegisterRequest request = new RegisterRequest();
         request.setName("Joan");
         request.setPassword("Jo_an8");
         request.setEmail("joan@gmail.com");
         request.setGender(Gender.MALE);
         assertThrows(InvalidFieldsException.class,()->userService.register(request));
     }
     @Test
     public void Registration_WithWrongEmail_FieldTest(){
         RegisterRequest request = new RegisterRequest();
         request.setName("Joan");
         request.setPassword("Abcd123!");
         request.setEmail("userexample..com");
         request.setGender(Gender.FEMALE);
         assertThrows(InvalidFieldsException.class,()->userService.register(request));
     }

    @Test
    public  void registerTest(){
         RegisterRequest request = new RegisterRequest();
         request.setName("Jonathan");
         request.setPassword("Abcd@123");
         request.setEmail("example.user123@example.com");
         request.setGender(Gender.MALE);
         userService.register(request);
         assertEquals(1,userRepository.count());
    }

    @Test
     public void UnregisteredUser_loginTest(){
        LoginRequest request = new LoginRequest();
        request.setName("Cynthia");
        request.setEmail("examplry.user123@example.com");
        
        assertThrows(UserNotFoundException.class,()-> userService.login(request));
    }

    @Test
     public void loginTest(){
        LoginRequest request = new LoginRequest();
        request.setName("Jonathan");
        request.setEmail("example.user123@example.com");
        userService.login(request);
    }

    
    @Test
     public void findTicket_Test(){

        TicketRequest request = new TicketRequest();
    }
   

}