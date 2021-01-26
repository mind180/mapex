package com.roadmapex.roadmapex.model;

import com.roadmapex.roadmapex.dto.edge.EdgeDto;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Edge {
  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne
  private Canvas canvas;

  @Column(name = "connection_point_id_from")
  private String connectionPointIdFrom;

  @Column(name = "from_x")
  private Integer fromX;

  @Column(name = "from_y")
  private Integer fromY;

  @Column(name = "connection_point_id_to")
  private String connectionPointIdTo;

  @Column(name = "to_x")
  private Integer toX;

  @Column(name = "to_y")
  private Integer toY;

  public Edge() {
  }

  public Edge(EdgeDto edgeDto) {
    this(edgeDto.getFrom().getConnectionPointId(),
        edgeDto.getFrom().getX(),
        edgeDto.getFrom().getY(),
        edgeDto.getTo().getConnectionPointId(),
        edgeDto.getTo().getX(),
        edgeDto.getTo().getY()
    );
  }

  public Edge(String connectionPointIdFrom, Integer fromX, Integer fromY,
              String connectionPointIdTo, Integer toX, Integer toY) {
    this.connectionPointIdFrom = connectionPointIdFrom;
    this.fromX = fromX;
    this.fromY = fromY;
    this.connectionPointIdTo = connectionPointIdTo;
    this.toX = toX;
    this.toY = toY;
  }

  public Edge(Canvas canvas, String connectionPointIdFrom, Integer fromX, Integer fromY,
              String connectionPointIdTo, Integer toX, Integer toY) {
    this.canvas = canvas;
    this.connectionPointIdFrom = connectionPointIdFrom;
    this.fromX = fromX;
    this.fromY = fromY;
    this.connectionPointIdTo = connectionPointIdTo;
    this.toX = toX;
    this.toY = toY;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Canvas getCanvas() {
    return canvas;
  }

  public void setCanvas(Canvas canvas) {
    this.canvas = canvas;
  }

  public String getConnectionPointIdFrom() {
    return connectionPointIdFrom;
  }

  public void setConnectionPointIdFrom(String connectionPointIdFrom) {
    this.connectionPointIdFrom = connectionPointIdFrom;
  }

  public void setConnectionPointIdTo(String connectionPointIdTo) {
    this.connectionPointIdTo = connectionPointIdTo;
  }

  public Integer getFromX() {
    return fromX;
  }

  public void setFromX(Integer fromX) {
    this.fromX = fromX;
  }

  public Integer getFromY() {
    return fromY;
  }

  public void setFromY(Integer fromY) {
    this.fromY = fromY;
  }

  public String getConnectionPointIdTo() {
    return connectionPointIdTo;
  }

  public Integer getToX() {
    return toX;
  }

  public void setToX(Integer toX) {
    this.toX = toX;
  }

  public Integer getToY() {
    return toY;
  }

  public void setToY(Integer toY) {
    this.toY = toY;
  }

  public void updateFromDto(EdgeDto edgeDto) {
    this.setConnectionPointIdFrom(edgeDto.getFrom().getConnectionPointId());
    this.setFromX(edgeDto.getFrom().getX());
    this.setFromY(edgeDto.getFrom().getY());
    this.setConnectionPointIdTo(edgeDto.getTo().getConnectionPointId());
    this.setToX(edgeDto.getTo().getX());
    this.setToY(edgeDto.getTo().getY());
  }
}
