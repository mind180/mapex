package com.roadmapex.roadmapex.services.users;

import com.roadmapex.roadmapex.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  public UserServiceImpl() {
  }

  @Override
  public boolean isAuthenticated() {
    return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
  }

  @Override
  public Optional<User> getUser() {
    return Optional.of(
        (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
  }
}
