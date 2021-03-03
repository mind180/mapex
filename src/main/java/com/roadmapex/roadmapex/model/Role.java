package com.roadmapex.roadmapex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Role {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

  public Role() {
  }

  public Role(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
