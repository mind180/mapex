package com.roadmapex.roadmapex.repository.canvas;

import com.roadmapex.roadmapex.model.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CanvasRepository extends JpaRepository<Canvas, UUID> {
  Optional<Canvas> findByName(String name);
}
