package com.roadmapex.roadmapex.dto.canvas;

import com.roadmapex.roadmapex.dto.edge.EdgeDto;
import com.roadmapex.roadmapex.dto.node.NodeDto;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.model.Edge;
import com.roadmapex.roadmapex.model.Node;

import java.util.ArrayList;
import java.util.List;

public class CanvasDto {
  private String id;
  private String name;
  private String description;
  private List<NodeDto> nodes = new ArrayList();
  private List<EdgeDto> edges = new ArrayList();

  public CanvasDto() {
  }

  public CanvasDto(Canvas canvas) {
    this.id = canvas.getId().toString();
    this.name = canvas.getName();
    this.description = canvas.getDescription();
    this.setNodeDtosFromNodes(canvas.getNodes());
    this.setEdgeDtosFromEdges(canvas.getEdges());
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

  public List<NodeDto> getNodes() {
    return nodes;
  }

  public void setNodes(List<NodeDto> nodes) {
    this.nodes = nodes;
  }

  public void setNodeDtosFromNodes(List<Node> lstNodes) {
    for (Node node : lstNodes) {
      nodes.add(new NodeDto(node));
    }
  }

  public List<EdgeDto> getEdges() {
    return edges;
  }

  public void setEdges(List<EdgeDto> edges) {
    this.edges = edges;
  }

  public void setEdgeDtosFromEdges(List<Edge> lstEdges) {
    for (Edge edge : lstEdges) {
      edges.add(new EdgeDto(edge));
    }
  }
}
