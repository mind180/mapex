package com.roadmapex.roadmapex.dto.edge;

public class EdgeSide {
  private String connectionPointId;
  private Integer x;
  private Integer y;

  public EdgeSide() {
  }

  public EdgeSide(String connectionPointId, Integer x, Integer y) {
    this.connectionPointId = connectionPointId;
    this.x = x;
    this.y = y;
  }

  public String getConnectionPointId() {
    return connectionPointId;
  }

  public void setConnectionPointId(String connectionPointId) {
    this.connectionPointId = connectionPointId;
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
