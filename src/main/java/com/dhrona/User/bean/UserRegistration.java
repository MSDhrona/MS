package com.dhrona.User.bean;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserRegistration {
    @NotEmpty(message = "userName should not be empty")
    private String userName;
    @NotEmpty(message = "password should not be empty")
    private String password;
    private String firstName;
    private String lastName;
    @NotEmpty(message = "email Id should not be empty")
    @Email(message = "invalid emaild Id")
    private String emailId;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobileNo;
    private char gender;
    private int age;



}
