package com.dhrona.User.service;

import com.dhrona.User.bean.UserRegistration;
import com.dhrona.User.entity.UserDetails;
import com.dhrona.User.repository.UserDetailsRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails register(UserRegistration userRegistration) {
        UserDetails registeredUser = null;
        boolean validRequest = validateUserRegistrationRequest(userRegistration);
        if(validRequest)
        {
            try{
                UserDetails userDetails = frameUserDetails(userRegistration);
                registeredUser =   userDetailsRepository.save(userDetails);
            }catch(Exception e){
            }

        }else{
        }

        return registeredUser;
    }

    private UserDetails frameUserDetails(UserRegistration userRegistration) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName(userRegistration.getUserName());
        userDetails.setPassword(hashPassword(userRegistration.getPassword()));
        userDetails.setEmailId(userRegistration.getEmailId());
        if (StringUtils.hasText(userRegistration.getUserName()))
            userDetails.setFirstName(userRegistration.getUserName());
        if (StringUtils.hasText(userRegistration.getLastName()))
            userDetails.setLastName(userRegistration.getLastName());
        if(StringUtils.hasText(userRegistration.getMobileNo()))
            userDetails.setMobileNo(userRegistration.getMobileNo());
        return userDetails;
    }

    private String hashPassword(String password) {
        return  BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean validateUserRegistrationRequest(UserRegistration userRegistration) {
        boolean validRequest = false;
        System.out.println("validateUserRegistrationRequest:"+userRegistration.getUserName());
        System.out.println("validateUserRegistrationRequest:"+userRegistration.getEmailId());
        System.out.println("validateUserRegistrationRequest:"+userRegistration.getPassword());
        if (userRegistration != null && StringUtils.hasText(userRegistration.getUserName()) &&
                StringUtils.hasText(userRegistration.getEmailId()) &&
                StringUtils.hasText(userRegistration.getPassword())
        ) {
            validRequest = true;
        }
        System.out.println("valid Request:"+validRequest);
        return validRequest;
    }

    private void checkPassWord(String password, String hashedPassword) {
        if (BCrypt.checkpw(password, hashedPassword))
            System.out.println("The password matches.");
        else
            System.out.println("The password does not match.");
    }
}