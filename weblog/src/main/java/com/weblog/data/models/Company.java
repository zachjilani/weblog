package com.weblog.data.models;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "company", schema = "public")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)

  @NonNull
  private Long app_id;

  @NonNull
  private String name;

  @NonNull
  private String position;

  public void setId(Long id) {
    this.app_id = id;
  }

  public Long getId() {
    return app_id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }
}
