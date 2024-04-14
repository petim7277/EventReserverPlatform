package com.Event.EventEaze.Data.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@ToString
public class Ticket {
    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Long id;
    private String username;
    private LocalDateTime purchaseDate;
    private LocalDateTime expirationDate;
    private String seatNumber;
    private String eventFee;
    @Enumerated(EnumType.STRING)
    private Gender userGender;
    @Enumerated(EnumType.STRING)
    private TicketCategory ticketCategory;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    @ManyToOne
    private Event  events;
}
