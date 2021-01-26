package com.roadmapex.roadmapex.dto.node;

public class Position {
  private Integer x;
  private Integer y;

  public Position() {
    this(0, 0);
  }

  public Position(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }
}
