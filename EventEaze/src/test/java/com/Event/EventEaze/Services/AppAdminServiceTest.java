package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Repositories.AdminRepository;
import com.Event.EventEaze.Data.Repositories.EventRepository;
import com.Event.EventEaze.Data.Repositories.TicketRepository;
import com.Event.EventEaze.Dtos.Requests.EventRequest;
import com.Event.EventEaze.Dtos.Requests.LoginRequest;
import com.Event.EventEaze.Dtos.Requests.RegisterRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import com.Event.EventEaze.Dtos.Responses.TicketResponse;
import com.Event.EventEaze.Exceptions.EventNotFoundException;
import com.Event.EventEaze.Exceptions.InvalidFieldsException;
import com.Event.EventEaze.Exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppAdminServiceTest {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void Registration_WithWrongUsername_FieldTest(){
        RegisterRequest request = new RegisterRequest();
        request.setName("jo");
        request.setPassword("Jo_mie8");
        request.setEmail("jobs@gmail.com");
        assertThrows(InvalidFieldsException.class,()->adminService.register(request));

    }
    @Test
    public void Registration_WithWrongPassword_FieldTest(){
        RegisterRequest request = new RegisterRequest();
        request.setName("Joan");
        request.setPassword("Jo_an8");
        request.setEmail("joan@gmail.com");
        assertThrows(InvalidFieldsException.class,()->adminService.register(request));
    }
    @Test
    public void Registration_WithWrongEmail_FieldTest(){
        RegisterRequest request = new RegisterRequest();
        request.setName("Joan");
        request.setPassword("Abcd123!");
        request.setEmail("userexample..com");
        assertThrows(InvalidFieldsException.class,()->adminService.register(request));
    }

    @Test
    public  void registerTest(){
        RegisterRequest request = new RegisterRequest();
        request.setName("Jonathan");
        request.setPassword("Abcd@123");
        request.setEmail("example.user123@example.com");
        adminService.register(request);
        assertEquals(1,adminRepository.count());
    }

    @Test
    public void UnregisteredUser_loginTest(){
        LoginRequest request = new LoginRequest();
        request.setName("Cynthia");
        request.setEmail("examplry.user123@example.com");

        assertThrows(UserNotFoundException.class,()-> adminService.login(request));
    }

    @Test
    public void loginTest(){
        LoginRequest request = new LoginRequest();
        request.setName("Jonathan");
        request.setEmail("example.user123@example.com");
        adminService.login(request);
    }

    @Test
    public void eventCreationTest(){
        EventRequest eventRequest = new EventRequest();
        eventRequest.setEventName("concert");
        eventRequest.setEventDate(LocalDate.of(2024,5,1));
        eventRequest.setAvailableAttendees(50);
        eventRequest.setEventVenue("Lekki peninsula hall ");
        eventRequest.setEventDescription("An 02 Arena concert by Davido");
        adminService.createEvents(eventRequest);
        assertEquals(1,eventRepository.count());

    }

    @Test
    public void testThatAn_ExistingEventCan_BeCreated(){
        EventRequest eventRequest = new EventRequest();
        eventRequest.setEventName("concert");
        eventRequest.setEventDate(LocalDate.of(2024,5,1));
        eventRequest.setAvailableAttendees(50);
        eventRequest.setEventDescription("An 02 Arena concert by Davido");
        assertThrows(EventNotFoundException.class,()->adminService.createEvents(eventRequest));
    }

    @Test
    public void ticketCreationTest(){
        TicketRequest request = new TicketRequest();
//        request.setUsername("Jonathan");
//        request.setEventFee("20000.00");
//        request.setPurchaseDate(LocalDate.of(2024,5,1));
//        request.setExpirationDate(LocalDate.of(2024,5,1));
//        request.setSeatNumber("01");
//        request.setUserGender(Gender.valueOf("MALE"));
//        request.setTicketCategory(TicketCategory.valueOf("EARLYBIRD"));
//        request.setTicketStatus(TicketStatus.valueOf("CONFIRMED"));
        TicketResponse response = adminService.createTicket(request);
//        assertNotNull(response);
    }
    
}