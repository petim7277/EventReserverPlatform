package com.Event.EventEaze.Utills;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateName(String name){
        return Pattern.matches("^[a-zA-Z]{4,12}$",name);
    }
    public static boolean validatePassword(String password){
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",password);
    }
    public static  boolean validateEmail(String email){
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",email);
    }
}
