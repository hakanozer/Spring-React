package com.works.entities;

import lombok.Data;

@Data
public class UserPassword{

    private int userId;
    private String oldPassword, newPassword;
}