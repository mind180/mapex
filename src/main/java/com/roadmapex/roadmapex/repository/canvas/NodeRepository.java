package com.roadmapex.roadmapex.repository.canvas;

import com.roadmapex.roadmapex.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NodeRepository extends JpaRepository<Node, UUID> {
}
