package com.Event.EventEaze.Dtos.Requests;
import com.Event.EventEaze.Data.Models.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String password;
    private String email;
    private Gender gender;
}
