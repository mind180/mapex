package com.roadmapex.roadmapex.controllers.api;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import com.roadmapex.roadmapex.dto.edge.EdgeDto;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.model.Edge;
import com.roadmapex.roadmapex.repository.canvas.CanvasRepository;
import com.roadmapex.roadmapex.repository.canvas.EdgeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/canvas/{canvasId}")
public class EdgeController {
  private CanvasRepository canvasRepository;
  private EdgeRepository edgeRepository;

  public EdgeController(CanvasRepository canvasRepository, EdgeRepository edgeRepository) {
    this.canvasRepository = canvasRepository;
    this.edgeRepository = edgeRepository;
  }

  @PostMapping("/edges")
  public List<EdgeDto> saveEdges(@PathVariable String canvasId, @RequestBody List<EdgeDto> lstEdgesDto) {
    List<Edge> lstEdges = new ArrayList<>();
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    for (EdgeDto edgeDto : lstEdgesDto) {
      Edge edge = new Edge(edgeDto);
      edge.setCanvas(opCanvas.get());
      lstEdges.add(edge);
    }

    List<Edge> lstSavedEdges = edgeRepository.saveAll(lstEdges);

    List<EdgeDto> lstSavedEdgesDto = new ArrayList<>();
    for (Edge edge : lstSavedEdges) {
      EdgeDto edgeDto = new EdgeDto(edge);
      lstSavedEdgesDto.add(edgeDto);
    }

    return lstSavedEdgesDto;
  }

  @DeleteMapping("/edges/{edgeId}")
  public void deleteById(@PathVariable String canvasId, @PathVariable String edgeId) {
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    List<Edge> lstEdges = opCanvas.get().getEdges();
    Optional<Edge> edgeToDelete = lstEdges.stream().filter(edge -> edge.getId().toString().equals(edgeId)).findAny();

    if (edgeToDelete.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Edge not found", Arrays.asList(""));
    }
  }

  @DeleteMapping("/edges")
  public void deleteAllById(@PathVariable String canvasId, @RequestParam String ids) {
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    String[] edgeIds = ids.split(",");
    List<UUID> lstEdgeIds = Arrays.stream(edgeIds).map(edgeId -> UUID.fromString(edgeId)).collect(Collectors.toList());

    List<Edge> lstEdgesForDelete = edgeRepository.findAllById(lstEdgeIds);
    edgeRepository.deleteAll(lstEdgesForDelete);
  }

  @PutMapping("/edges")
  public List<EdgeDto> update(@PathVariable String canvasId, @RequestBody List<EdgeDto> updatedEdges) {
    Optional<Canvas> opCanvas = canvasRepository.findById(UUID.fromString(canvasId));

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }

    List<Edge> lstEdges = opCanvas.get().getEdges();

    List<UUID> updatedEdgeIds = updatedEdges.stream().map(edgeDto ->
        UUID.fromString(edgeDto.getId())).collect(Collectors.toList());
    List<Edge> edgesToUpdate = lstEdges.stream().filter(edge ->
        updatedEdgeIds.contains(edge.getId())).collect(Collectors.toList());

    for (Edge edge : edgesToUpdate) {
      Optional<EdgeDto> correspondingEdgeDto =
        updatedEdges.stream().filter(edgeDto -> UUID.fromString(edgeDto.getId()).equals(edge.getId())).findFirst();
      edge.updateFromDto(correspondingEdgeDto.get());
    }

    edgeRepository.saveAll(edgesToUpdate);
    return updatedEdges;
  }
}
