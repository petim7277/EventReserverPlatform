package com.Event.EventEaze.Exceptions;

public class TicketNotFoundException extends  RuntimeException{
   public TicketNotFoundException(String message) {
       super(message);
   }
}
