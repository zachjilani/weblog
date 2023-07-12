package com.weblog.data.models;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users", schema = "public")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)

  @NonNull
  private Long user_id;

  @NonNull
  private String firstname;

  @NonNull
  private String lastname;

  // @NonNull
  // private String email;

  public void setId(Long user_id) {
    this.user_id = user_id;
  }

  public void setFirstName(String firstname) {
    this.firstname = firstname;
  }

  public String getFirstName() {
    return firstname;
  }

  public void setLastName(String lastname) {
    this.lastname = lastname;
  }

  public String getLastName() {
    return lastname;
  }

  // public void setEmail(String email) {
  // this.email = email;
  // }

  // public String getEmail() {
  // return email;
  // }

}
