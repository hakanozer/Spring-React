package com.example.entities;

import lombok.Data;

@Data
public class UserPersonPassword {

    private int uid;
    private String oldPassword;
    private String newPassword;

}
