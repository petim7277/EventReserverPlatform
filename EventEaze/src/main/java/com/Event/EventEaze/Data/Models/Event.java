package com.Event.EventEaze.Data.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@ToString
public class Event {
    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Long id ;
    private String eventName;
    private String eventVenue;
    private LocalDate date;
    private Integer availableAttendees;
    private String eventDescription;
    @OneToMany
   private List<Ticket> tickets;
}
