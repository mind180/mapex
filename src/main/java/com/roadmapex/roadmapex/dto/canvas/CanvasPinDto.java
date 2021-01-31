package com.roadmapex.roadmapex.dto.canvas;

import com.roadmapex.roadmapex.model.Canvas;

public class CanvasPinDto {
  private String id;
  private String name;
  private String description;

  public CanvasPinDto() {

  }

  public CanvasPinDto(Canvas canvas) {
    this.id = canvas.getId().toString();
    this.name = canvas.getName();
    this.description = canvas.getDescription();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
