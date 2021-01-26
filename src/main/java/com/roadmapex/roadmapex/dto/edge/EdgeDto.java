package com.roadmapex.roadmapex.dto.edge;

import com.roadmapex.roadmapex.model.Edge;

public class EdgeDto {
  private String id;
  private EdgeSide from;
  private EdgeSide to;

  public EdgeDto() {
  }

  public EdgeDto(Edge edge) {
    this.id = edge.getId().toString();
    this.from = new EdgeSide(edge.getConnectionPointIdFrom(), edge.getFromX(), edge.getFromY());
    this.to = new EdgeSide(edge.getConnectionPointIdTo(), edge.getToX(), edge.getToY());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EdgeSide getFrom() {
    return from;
  }

  public void setFrom(EdgeSide from) {
    this.from = from;
  }

  public EdgeSide getTo() {
    return to;
  }

  public void setTo(EdgeSide to) {
    this.to = to;
  }
}
