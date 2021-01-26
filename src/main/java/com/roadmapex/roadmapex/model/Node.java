package com.roadmapex.roadmapex.model;

import com.roadmapex.roadmapex.dto.node.NodeDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Node {
  @Id
  @GeneratedValue
  private UUID id;
  private String title;
  private String color;
  private Integer positionX;
  private Integer positionY;

  @ManyToOne
  private Canvas canvas;

  public Node() {}

  public Node(NodeDto nodeDto) {
    this(nodeDto.getData().getTitle(),
        nodeDto.getData().getColor(),
        nodeDto.getPosition().getX(),
        nodeDto.getPosition().getY());
  }

  public Node(String title, String color, Integer positionX, Integer positionY) {
    this.title = title;
    this.positionX = positionX;
    this.positionY = positionY;
    this.color = color;
  }

  public Node(UUID id, String title, Integer positionX, Integer positionY, String color) {
    this.id = id;
    this.title = title;
    this.positionX = positionX;
    this.positionY = positionY;
    this.color = color;
  }

  public UUID getId() {
    return id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPositionX() {
    return positionX;
  }

  public void setPositionX(Integer positionX) {
    this.positionX = positionX;
  }

  public Integer getPositionY() {
    return positionY;
  }

  public void setPositionY(Integer positionY) {
    this.positionY = positionY;
  }

  public Canvas getCanvas() {
    return canvas;
  }

  public void setCanvas(Canvas canvas) {
    this.canvas = canvas;
  }

  public void updateFromDto(NodeDto nodeDto) {
    this.setTitle(nodeDto.getData().getTitle());
    this.setColor(nodeDto.getData().getColor());
    this.setPositionX(nodeDto.getPosition().getX());
    this.setPositionY(nodeDto.getPosition().getY());
  }
}
