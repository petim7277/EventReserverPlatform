package com.Event.EventEaze.Data.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class Admin {
    @Id
    @GeneratedValue (strategy = IDENTITY)
    private  Long id;
    private  String name;
    private  String email;
    private  String password;
}
