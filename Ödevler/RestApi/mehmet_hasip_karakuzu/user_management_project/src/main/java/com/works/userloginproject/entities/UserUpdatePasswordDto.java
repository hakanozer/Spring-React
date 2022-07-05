package com.works.userloginproject.entities;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserUpdatePasswordDto implements Serializable {

  private String password;

  private String oldPassword;

  public UserUpdatePasswordDto(User user) {
    this.setPassword(user.getPassword());
  }

}
