package com.roadmapex.roadmapex.model;

import com.roadmapex.roadmapex.dto.canvas.CanvasDto;
import com.roadmapex.roadmapex.dto.edge.EdgeDto;
import com.roadmapex.roadmapex.dto.node.NodeDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Canvas {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private String description;

  @ManyToOne
  private User user;

  @OneToMany(mappedBy = "canvas")
  List<Node> nodes = new ArrayList<>();

  @OneToMany(mappedBy = "canvas")
  List<Edge> edges = new ArrayList<>();

  public Canvas() {
  }

  public Canvas(CanvasDto canvasDto) {
    this.name = canvasDto.getName();
    this.description = canvasDto.getDescription();
  }

  public Canvas(UUID id, String name, List<Node> nodes, List<Edge> edges) {
    this.id = id;
    this.name = name;
    this.nodes = nodes;
    this.edges = edges;
  }

  public UUID getId() {
    return id;
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

  public List<Node> getNodes() {
    return nodes;
  }

  public void setNodes(List<Node> nodes) {
    this.nodes = nodes;
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public void setEdges(List<Edge> edges) {
    this.edges = edges;
  }

  public List<Node> getNodesFromNodeDtos(List<NodeDto> nodeDtos) {
    List<Node> nodes = new ArrayList<>();

    for (NodeDto nodeDto : nodeDtos) {
      Node node = new Node(
        UUID.fromString(nodeDto.getId()),
        nodeDto.getData().getTitle(),
        nodeDto.getPosition().getX(),
        nodeDto.getPosition().getY(),
        nodeDto.getData().getColor()
      );
      nodes.add(node);
    }
    return nodes;
  }

  public List<Edge> getEdgesFromEdgeDtos(List<EdgeDto> edgeDtos) {
    List<Edge> edges = new ArrayList<>();

    for (EdgeDto edgeDto : edgeDtos) {
      Edge edge = new Edge(
        edgeDto.getFrom().getConnectionPointId(),
        edgeDto.getFrom().getX(),
        edgeDto.getFrom().getY(),
        edgeDto.getTo().getConnectionPointId(),
        edgeDto.getTo().getX(),
        edgeDto.getTo().getY()
      );
      edges.add(edge);
    }
    return edges;
  }
}
