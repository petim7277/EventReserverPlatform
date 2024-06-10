package com.Event.EventEaze.Services;
import com.Event.EventEaze.Data.Models.Event;
import com.Event.EventEaze.Data.Repositories.EventRepository;
import com.Event.EventEaze.Dtos.Requests.EventRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.EventRequest;
import com.Event.EventEaze.Dtos.Responses.EventResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
 @SpringBootTest
class AppEventServiceTest {
     @Autowired
     private EventService  eventService;
     @Autowired
     private EventRepository eventRepository;

  @Test
  public void createEventTest(){
      EventRequest eventRequest = new EventRequest();
      eventRequest.setEventName("Innovation");
      eventRequest.setEventVenue("312 herbert macaulay sabo yaba lagos");
      eventRequest.setEventDescription("Semicolon in collaboration with Interswitch");
      eventRequest.setEventDate(LocalDate.of(2024,5,15));
      eventRequest.setAvailableAttendees(1000);
      EventResponse response = eventService.createEvent(eventRequest);
      assertNotNull(response);
      System.out.println(response.toString());
      assertEquals(3,eventRepository.count());

  }

     @Test
     public void createEventAgainTest(){
         EventRequest eventRequest = new EventRequest();
         eventRequest.setEventName("Rendezvous");
         eventRequest.setEventVenue("312 herbert macaulay way New Jersey");
         eventRequest.setEventDescription("AfricanTalents in collaboration with Interswitch");
         eventRequest.setEventDate(LocalDate.of(2024,6,15));
         eventRequest.setAvailableAttendees(1000);
         EventResponse response = eventService.createEvent(eventRequest);
         assertNotNull(response);
         System.out.println(response.toString());
         assertEquals(4,eventRepository.count());

     }


     @Test
     public void removeEventTest(){
         EventRemoveRequest eventRequest = new EventRemoveRequest();
         eventRequest.setEventName("MetGala");
         EventResponse response = eventService.removeEvent(eventRequest);
         assertNotNull(response);
         System.out.println(response.toString());
         assertEquals(2,eventRepository.count());

     }
     @Test
     public void findByEventNameTest(){
      String eventName = "MetGala";
         Event event = eventRepository.findByEventName(eventName);
         assertNotNull(event);

     }

}