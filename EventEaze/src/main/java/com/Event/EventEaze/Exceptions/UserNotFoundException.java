package com.Event.EventEaze.Exceptions;
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }

}
