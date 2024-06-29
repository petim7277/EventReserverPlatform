package com.Event.EventEaze.Services;
import com.Event.EventEaze.Data.Models.Event;
import com.Event.EventEaze.Data.Models.TicketStatus;
import com.Event.EventEaze.Data.Repositories.EventRepository;
import com.Event.EventEaze.Data.Repositories.TicketRepository;
import com.Event.EventEaze.Dtos.Requests.TicketRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppTicketServiceTest {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;
//    @AfterEach
//    public  void deleteData () {
//        ticketRepository.deleteAll();
//    }
//    @BeforeEach
//    public  void deleteInfo () {
//        ticketRepository.deleteAll();
//    }
   @Test
    public  void TicketCreationTest(){
       TicketRequest ticketRequest  = new TicketRequest();
        ticketRequest.setEventName("MetGala");
        ticketRequest.setEventDate("2024,6,15");
        ticketService.createTicket(ticketRequest);
        assertEquals(1,ticketRepository.count());

   }

    @Test
    public  void TicketCreationTestAgain(){
        TicketRequest ticketRequest  = new TicketRequest();
        ticketRequest.setEventName("Rendezvous");
        ticketRequest.setEventDate("2024,6,15");
        ticketService.createTicket(ticketRequest);
        assertEquals(2,ticketRepository.count());

    }

//    @Test
//    public  void TicketDeletionTestAgain(){
//        TicketRemoveRequest ticketRequest  = new TicketRemoveRequest();
//        ticketRequest.setEventName("MetGalad");
//        ticketService.removeTicket(ticketRequest);
//        assertEquals(1,ticketRepository.count());
//
//    }
}