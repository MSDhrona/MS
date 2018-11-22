package com.dhrona.User.repository;

import com.dhrona.User.bean.UserRegistration;
import com.dhrona.User.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails,Object> {
}
