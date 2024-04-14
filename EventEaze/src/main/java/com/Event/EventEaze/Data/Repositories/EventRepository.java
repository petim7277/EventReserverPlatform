package com.Event.EventEaze.Data.Repositories;

import com.Event.EventEaze.Data.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EventRepository extends JpaRepository<Event,Long> {

    Event findByDate(LocalDate date);
}
