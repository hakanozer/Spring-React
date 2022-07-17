package com.works.tekrarproject.entities;

import lombok.Data;

@Data
public class UserPassword {

    private Integer uid;
    private String oldPassword;
    private String newPassword;

}
