package com.roadmapex.roadmapex.repository.canvas;

import com.roadmapex.roadmapex.model.Edge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EdgeRepository extends JpaRepository<Edge, UUID> {
  void deleteAllByIdIn(List<UUID> ids);
}
