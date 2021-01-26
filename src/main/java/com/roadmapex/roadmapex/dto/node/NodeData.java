package com.roadmapex.roadmapex.dto.node;

public class NodeData {
  private String title;
  private String color;

  public NodeData() {
  }

  public NodeData(String title, String color) {
    this.title = title;
    this.color = color;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
