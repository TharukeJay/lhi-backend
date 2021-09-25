package com.tharuke.lhi.controller;


import com.tharuke.lhi.repository.model.LoginRequest;
import com.tharuke.lhi.repository.model.RegisterRequest;
import com.tharuke.lhi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class UserController {

   public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> loggingUser(@RequestBody LoginRequest loginRequest) {
        Map<String,Object> loggedUser = userService.logUser(loginRequest);

        return ResponseEntity.ok(loggedUser);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> registerUser(@RequestBody RegisterRequest registerRequest) {
        Map<String, Object> savedUser = userService.saveUser(registerRequest);

        return ResponseEntity.ok(savedUser);
    }
}
