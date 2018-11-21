package com.dhrona.User.controller;

import com.dhrona.User.bean.UserRegistration;
import com.dhrona.User.entity.UserDetails;
import com.dhrona.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to dhrona MS session";
    }

    @PostMapping("/")
    public UserDetails register(@Valid @RequestBody UserRegistration registrationDetails){
        String response = null;
        UserDetails user = userService.register(registrationDetails);
        /*return new ResponseEntity<UserDetails>(user,HttpStatus.CREATED);*/
        return user;
    }


}
