package com.dhrona.User.controller;

import com.dhrona.User.bean.UserRegistration;
import com.dhrona.User.entity.UserDetails;
import com.dhrona.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to dhrona MS session";
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegistration registrationDetails){
        String response = null;
        System.out.println("Inside register");
        UserDetails user = userService.register(registrationDetails);
        if(user!=null){
            System.out.println("UserName" +user.getUserName());
            response = "User created Successfully";
        }else{
            response = "Unable to create User created Successfully";
            System.out.println("Error");
        }
        return response;
    }

//update
    //find by id
    //find all

}
