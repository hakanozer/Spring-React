package com.example.userprojem.entities;

import lombok.Data;

@Data
public class UserPassChange {


    private  Integer uid;
    private String email;
    private String password;
    private String newPassword;
}
