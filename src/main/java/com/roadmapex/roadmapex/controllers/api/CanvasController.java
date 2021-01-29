package com.roadmapex.roadmapex.controllers.api;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import com.roadmapex.roadmapex.dto.canvas.CanvasDto;
import com.roadmapex.roadmapex.dto.node.NodeDto;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.model.Node;
import com.roadmapex.roadmapex.repository.canvas.CanvasRepository;
import com.roadmapex.roadmapex.repository.canvas.NodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/canvas")
public class CanvasController {
  NodeRepository nodeRepository;
  CanvasRepository canvasRepository;

  public CanvasController(NodeRepository nodeRepository, CanvasRepository canvasRepository) {
    this.nodeRepository = nodeRepository;
    this.canvasRepository = canvasRepository;
  }

  @GetMapping("{id}")
  public CanvasDto get(@PathVariable String id) {
    Optional<Canvas> optionalCanvas = canvasRepository.findById(UUID.fromString(id));

    if (optionalCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas id not found", Arrays.asList(""));
    }
    return new CanvasDto(optionalCanvas.get());
  }

  @PostMapping()
  public CanvasDto post(@RequestBody CanvasDto canvasDto) {
    Canvas canvas = new Canvas(canvasDto);
    Canvas createdCanvas = canvasRepository.save(canvas);

    return new CanvasDto(createdCanvas);
  }
}
