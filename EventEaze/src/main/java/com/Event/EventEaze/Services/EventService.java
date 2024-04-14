package com.Event.EventEaze.Services;

import com.Event.EventEaze.Data.Models.Event;
import com.Event.EventEaze.Dtos.Requests.EventRemoveRequest;
import com.Event.EventEaze.Dtos.Requests.EventRequest;
import com.Event.EventEaze.Dtos.Responses.EventResponse;

import java.util.Optional;

public interface EventService {
    Optional<Event> findEvent(Long id);
    EventResponse createEvent (EventRequest eventRequest);
    EventResponse removeEvent (EventRemoveRequest eventRequest);
}
