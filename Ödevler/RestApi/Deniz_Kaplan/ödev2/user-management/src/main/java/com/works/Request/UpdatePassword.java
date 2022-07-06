package com.works.Request;

import lombok.Data;

@Data
public class UpdatePassword {

    private  String oldPassword;

    private  String newPassword;
}
