package com.roadmapex.roadmapex.services.users;

import com.roadmapex.roadmapex.model.User;

import java.util.Optional;

public interface UserService {

  boolean isAuthenticated();

  Optional<User> getUser();
}
