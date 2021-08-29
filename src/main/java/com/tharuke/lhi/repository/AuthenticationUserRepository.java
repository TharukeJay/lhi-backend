package com.tharuke.lhi.repository;

import com.tharuke.lhi.repository.model.user.AuthenticationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthenticationUserRepository extends MongoRepository<AuthenticationUser,String> {

    AuthenticationUser findByUserName(String userName);
    Optional<AuthenticationUser> findById(String userId);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
}
