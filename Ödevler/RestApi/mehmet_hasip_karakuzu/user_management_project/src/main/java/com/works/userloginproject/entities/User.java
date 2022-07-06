package com.works.userloginproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Length(min = 3, max = 13, message = "name must be min 3 max 13 character")
  private String name;

  @Length(min = 3, max = 13, message = "name must be min 3 max 13 character")
  private String surname;

  @Email(message = "Email is already in use", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
  private String email;

  private String password;

  private String oldPassword;

}
