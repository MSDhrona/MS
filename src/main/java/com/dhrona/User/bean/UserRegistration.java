package com.dhrona.User.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserRegistration {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNo;
    private char gender;
    private int age;



}
