package com.roadmapex.roadmapex.controllers.api;

import com.roadmapex.roadmapex.dto.canvas.CanvasDto;
import com.roadmapex.roadmapex.dto.canvas.CanvasPinDto;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.repository.canvas.CanvasRepository;
import com.roadmapex.roadmapex.repository.canvas.NodeRepository;
import com.roadmapex.roadmapex.services.canvas.CanvasService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/user/{userId}/canvas")
public class UserCanvasController {
  NodeRepository nodeRepository;
  CanvasRepository canvasRepository;
  CanvasService canvasService;

  public UserCanvasController(CanvasService canvasService, NodeRepository nodeRepository, CanvasRepository canvasRepository) {
    this.nodeRepository = nodeRepository;
    this.canvasRepository = canvasRepository;
    this.canvasService = canvasService;
  }

  @GetMapping()
  public List<CanvasPinDto> getAll(@PathVariable String userId) {
    List<Canvas> lstCanvases = canvasService.getUserCanvases(UUID.fromString(userId));

    List<CanvasPinDto> canvasesDtoList = new ArrayList<>();
    for (Canvas canvas : lstCanvases) {
      canvasesDtoList.add(new CanvasPinDto(canvas));
    }

    return canvasesDtoList;
  }

  @GetMapping("{canvasId}")
  public CanvasDto get(@PathVariable String userId, @PathVariable String canvasId) {
    Canvas canvas = canvasService.getUserCanvas(UUID.fromString(userId), UUID.fromString(canvasId));

    return new CanvasDto(canvas);
  }

}
