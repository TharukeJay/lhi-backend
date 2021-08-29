package com.tharuke.lhi.repository.model.user;

import com.tharuke.lhi.repository.model.PersistObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Document
public class AuthenticationUser extends PersistObject {

    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private int telephone;
    private UserRole userRole;
    protected UserStatus status;

    public enum UserRole {
        SUPER_ADMIN,
        ROLE_ADMIN,
        ROLE_USER
    }
}
