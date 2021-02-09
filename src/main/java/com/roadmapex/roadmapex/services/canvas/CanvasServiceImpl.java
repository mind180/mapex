package com.roadmapex.roadmapex.services.canvas;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import com.roadmapex.roadmapex.model.Canvas;
import com.roadmapex.roadmapex.model.User;
import com.roadmapex.roadmapex.repository.canvas.CanvasRepository;
import com.roadmapex.roadmapex.repository.canvas.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CanvasServiceImpl implements CanvasService {
  private UserRepository userRepository;
  private CanvasRepository canvasRepository;

  public CanvasServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<Canvas> getUserCanvases(UUID userId) {
    Optional<User> opUser = userRepository.getUserById(userId);

    if (opUser.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "User not found", Arrays.asList("user id"));
    }

    return opUser.get().getCanvases();
  }

  @Override
  public Canvas getUserCanvas(UUID userId, UUID canvasId) {
    Optional<User> opUser = userRepository.getUserById(userId);

    if (opUser.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "User not found", Arrays.asList("user id"));
    }

    List<Canvas> lstCanvas = opUser.get().getCanvases();
    Optional<Canvas> opCanvas =
        lstCanvas.stream().filter(canvas -> canvas.getId().equals(canvasId)).findFirst();

    if (opCanvas.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "Canvas not found", Arrays.asList("canvas id"));
    }

    return opCanvas.get();
  }
}
