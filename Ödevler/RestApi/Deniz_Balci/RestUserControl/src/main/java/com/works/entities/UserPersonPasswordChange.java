package com.works.entities;

import lombok.Data;

@Data
public class UserPersonPasswordChange {

    private String email;
    private String password;
    private String newPassword;
}
