package com.roadmapex.roadmapex.repository.canvas;

import com.roadmapex.roadmapex.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

  User getUserByUsername(String username);
}
