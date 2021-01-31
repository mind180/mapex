package com.roadmapex.roadmapex.controllers.api;

import com.roadmapex.roadmapex.dto.node.NodeDto;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.model.Node;
import com.roadmapex.roadmapex.repository.canvas.CanvasRepository;
import com.roadmapex.roadmapex.repository.canvas.NodeRepository;
import com.roadmapex.roadmapex.config.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/canvas/{canvasId}")
public class NodeController {
  private CanvasRepository canvasRepository;
  private NodeRepository nodeRepository;

  public NodeController(CanvasRepository canvasRepository, NodeRepository nodeRepository) {
    this.canvasRepository = canvasRepository;
    this.nodeRepository = nodeRepository;
  }

  @PostMapping("/nodes")
  public List<NodeDto> save(@PathVariable String canvasId, @RequestBody List<NodeDto> lstNodeDto) throws Exception {
    List<Node> lstNode = new ArrayList<>();
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    for (NodeDto nodeDto : lstNodeDto) {
      Node node = new Node(nodeDto);
      node.setCanvas(opCanvas.get());
      lstNode.add(node);
    }

    List<Node> lstSavedNodes = nodeRepository.saveAll(lstNode);

    List<NodeDto> lstSavedNodeDto = new ArrayList<>();
    for (Node node : lstSavedNodes) {
      NodeDto nodeDto = new NodeDto(node);
      lstSavedNodeDto.add(nodeDto);
    }

    return lstSavedNodeDto;
  }

  @DeleteMapping("/nodes/{nodeId}")
  public void delete(@PathVariable String canvasId, @PathVariable String nodeId) {
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    List<Node> lstNodes = opCanvas.get().getNodes();
    Optional<Node> nodeToDelete = lstNodes.stream().filter(node -> node.getId().toString().equals(nodeId)).findAny();

    if (nodeToDelete.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Node not found", Arrays.asList(""));
    }

    nodeRepository.delete(nodeToDelete.get());
  }

  @PutMapping("/nodes/{nodeId}")
  public NodeDto replace(@PathVariable String canvasId, @PathVariable String nodeId, @RequestBody NodeDto newNode) {
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    List<Node> lstNodes = opCanvas.get().getNodes();
    Optional<Node> nodeToReplace = lstNodes.stream().filter(node -> node.getId().toString().equals(nodeId)).findFirst();

    if (nodeToReplace.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Node not found", Arrays.asList(""));
    }

    nodeToReplace.get().updateFromDto(newNode);

    Node updatedNode = nodeRepository.save(nodeToReplace.get());
    return new NodeDto(updatedNode);
  }

}
