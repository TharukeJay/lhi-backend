package com.tharuke.lhi.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequest {

    private String userName;
    private String password;
}
