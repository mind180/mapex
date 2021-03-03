package com.roadmapex.roadmapex.dto;

import com.roadmapex.roadmapex.model.User;

public class UserDto {
  private String username;
  private String firstName;
  private String lastName;
  private String location;

  public UserDto(User user) {
    this.username = user.getUsername();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.location = user.getLocation();
  }

  public UserDto(String username, String firstName, String lastName, String location) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
