package com.dhrona.User.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UserDetails")
@Data
public class UserDetails {
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String emailId;
    private String mobileNo;
    private char gender;
    private int age;
}
