package com.growthx.assignmentportal.Utils;

import org.springframework.stereotype.Component;

@Component
public class utilities {

    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final String PASSWORD_INVALID = "The password entered is invalid";
    public static final String USER_EXISTS = "User already exists with this userId.";
}
