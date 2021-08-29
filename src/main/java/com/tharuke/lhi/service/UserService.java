package com.tharuke.lhi.service;

import com.tharuke.lhi.repository.AuthenticationUserRepository;
import com.tharuke.lhi.repository.model.LoginRequest;
import com.tharuke.lhi.repository.model.user.AuthenticationUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserService {

    private AuthenticationUserRepository authenticationUserRepository;

    public UserService(AuthenticationUserRepository authenticationUserRepository) {
        this.authenticationUserRepository = authenticationUserRepository;
    }

    public Map<String,Object> logUser(LoginRequest request) {

        Map<String, Object> response = new HashMap<>();
        AuthenticationUser authenticationUser = authenticationUserRepository.findByUserName(request.getUserName());
        String message = "Incorrect credentials";

        if (authenticationUser == null) {
            response.put("message", message);
            response.put("logged",false);

        } else if(!authenticationUser.getPassword().equals(request.getPassword())) {
            response.put("message", message);
            response.put("logged",false);

        } else if (authenticationUser.getUserRole().equals(AuthenticationUser.UserRole.ROLE_ADMIN) && authenticationUser.getPassword().equals(request.getPassword())) {
            response.put("isAdmin", true);
            response.put("logged", true);
            response.put("userId", authenticationUser);
        } else if (authenticationUser.getUserRole().equals(AuthenticationUser.UserRole.ROLE_USER) && authenticationUser.getPassword().equals(request.getPassword())) {
            response.put("isAdmin", false);
            response.put("logged", true);
            response.put("userId", authenticationUser.getId());
        } else {
            response.put("message", message);
            response.put("logged",false);
        }
        return response;
    }
}
