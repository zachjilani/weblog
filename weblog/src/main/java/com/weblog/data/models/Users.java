package com.weblog.data.models;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)

  @NonNull
  private Long id;

  @NonNull
  private String firstName;

  @NonNull
  private String lastName;

  @NonNull
  private String email;

  private String pictureUrl;

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPictureUrl(String url) {
    this.pictureUrl = url;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

}
