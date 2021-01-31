package com.roadmapex.roadmapex.controllers.api;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import com.roadmapex.roadmapex.dto.canvas.CanvasDto;
import com.roadmapex.roadmapex.dto.canvas.CanvasPinDto;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.repository.canvas.CanvasRepository;
import com.roadmapex.roadmapex.repository.canvas.NodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/canvas")
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

  @GetMapping()
  public List<CanvasPinDto> getAll() {
    List<Canvas> lstCanvases = canvasRepository.findAll();

    List<CanvasPinDto> canvasesDtoList = new ArrayList<>();
    for (Canvas canvas : lstCanvases) {
      canvasesDtoList.add(new CanvasPinDto(canvas));
    }

    return canvasesDtoList;
  }

  @PostMapping()
  public CanvasDto post(@RequestBody CanvasDto canvasDto) {
    Canvas canvas = new Canvas(canvasDto);
    Canvas createdCanvas = canvasRepository.save(canvas);

    return new CanvasDto(createdCanvas);
  }
}
