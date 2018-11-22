package com.dhrona.User.service;

import com.dhrona.User.bean.UserRegistration;
import com.dhrona.User.entity.UserDetails;

public interface UserService {
     UserDetails register(UserRegistration userRegistration) throws Exception;
}
