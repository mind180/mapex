package com.roadmapex.roadmapex.services.canvas;

import com.roadmapex.roadmapex.model.Canvas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CanvasService {

  List<Canvas> getUserCanvases(UUID userId);

  Canvas getUserCanvas(UUID userId, UUID canvasId);
}
