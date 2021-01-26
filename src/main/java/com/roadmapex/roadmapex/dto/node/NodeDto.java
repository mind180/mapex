package com.roadmapex.roadmapex.dto.node;

import com.roadmapex.roadmapex.model.Node;

public class NodeDto {
  private String id;
  private Position position;
  private NodeData data;

  public NodeDto() {
  }

  public NodeDto(Node node) {
    this.id = node.getId().toString();
    this.position = new Position(node.getPositionX(), node.getPositionY());
    this.data = new NodeData(node.getTitle(), node.getColor());
  }

  public NodeDto(String id, Position position, NodeData data) {
    this.id = id;
    this.position = position;
    this.data = data = data;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public NodeData getData() {
    return data;
  }

  public void setData(NodeData data) {
    this.data = data;
  }
}
