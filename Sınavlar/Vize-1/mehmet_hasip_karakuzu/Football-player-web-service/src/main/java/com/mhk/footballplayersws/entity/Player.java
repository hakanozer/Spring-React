package com.mhk.footballplayersws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long playerId;

  @Length(message = "name must be min 2, max 40 character", min = 2, max = 40)
  @NotBlank(message = "name can not be null")
  private String name;
  @Length(message = "name must be min 2, max 40 character", min = 2, max = 40)
  @NotBlank(message = "name can not be null")
  private String surname;

  @Email(message = "Email is already in use", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
  private String email;


  @Length(message = "password lent must be min 4, max 32 character", min = 4, max = 32)
  private String password;


  @Min(message = "age must be over 18", value = 18)
  @Column(nullable = false)
  private int age;

  @ManyToOne
  private Team team;
}
