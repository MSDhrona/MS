package com.dhrona.User.service;

import com.dhrona.User.bean.UserRegistration;
import com.dhrona.User.entity.UserDetails;
import com.dhrona.User.repository.UserDetailsRepository;
import com.dhrona.User.utility.UserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails register(UserRegistration userRegistration) throws Exception {
        UserDetails registeredUser = null;
            try{
                userRegistration.setPassword(UserUtils.hashPassword(userRegistration.getPassword()));
                UserDetails userDetails = new UserDetails();
                BeanUtils.copyProperties(userRegistration,userDetails);
                 registeredUser =   userDetailsRepository.save(userDetails);
            }catch(Exception e){
                 throw new Exception("Unable to register the User");
            }
        return registeredUser;
    }
}