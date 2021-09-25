package com.tharuke.lhi.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterRequest {

    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private int telephone;
}