package com.works.entities;

import lombok.Data;

@Data
public class UserPassword {

    private int uid;
    private String oldPassword;
    private String newPassword;

}
