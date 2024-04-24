package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.Event;
import com.Event.EventEaze.Data.Repositories.EventRepository;
import com.Event.EventEaze.Dtos.Requests.EventRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.EventRequest;
import com.Event.EventEaze.Dtos.Responses.EventResponse;
import com.Event.EventEaze.Exceptions.EventNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AppEventService implements EventService{
   private final EventRepository eventRepository;
    @Override
    public Optional<Event> findEvent(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public EventResponse createEvent(EventRequest eventRequest) {
        ModelMapper mapper = new ModelMapper();
        EventResponse response = new EventResponse();
        Event foundEvent  = eventRepository.findByDate(eventRequest.getEventDate());
        if (foundEvent != null)
            throw  new EventNotFoundException("Event already  exist") ;
        foundEvent = mapper.map(eventRequest, Event.class);
        eventRepository.save(foundEvent);
        response.setMessage("Event successfully created");
        return response;
    }

    @Override
    public EventResponse removeEvent(EventRemoveRequest eventRequest) {
        ModelMapper mapper = new ModelMapper();
        EventResponse response = new EventResponse();
        Event foundEvent  = eventRepository.findByEventName(eventRequest.getEventName());
        if (foundEvent == null)
            throw  new EventNotFoundException("Event does not  exist") ;
        foundEvent = mapper.map(eventRequest, Event.class);
        eventRepository.delete(foundEvent);
        response.setMessage("Event successfully removed");
        return response;

    }

  
}
