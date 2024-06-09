package com.Event.EventEaze.Services;
import com.Event.EventEaze.Data.Models.TicketStatus;
import com.Event.EventEaze.Data.Repositories.TicketRepository;
import com.Event.EventEaze.Dtos.Requests.TicketRequest;
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
   @Test
    public  void TicketCreationTest(){
       TicketRequest ticketRequest  = new TicketRequest();
        ticketRequest.setEventName("MetGallery");
        ticketRequest.setEventDate("2024,6,15");
        ticketService.createTicket(ticketRequest);
        assertEquals(1,ticketRepository.count());

   }
}