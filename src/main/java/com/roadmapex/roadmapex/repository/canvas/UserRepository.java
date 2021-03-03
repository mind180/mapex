package com.roadmapex.roadmapex.repository.canvas;

import com.roadmapex.roadmapex.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

  Optional<User> getUserByUsername(String username);

  Optional<User> getUserById(UUID id);
}
