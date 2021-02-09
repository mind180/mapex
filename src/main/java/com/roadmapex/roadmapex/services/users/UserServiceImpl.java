package com.roadmapex.roadmapex.services.users;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import com.roadmapex.roadmapex.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Arrays;
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
  public User getUser() {
    Optional<User> opUser = Optional.of(
        (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

    if (opUser.isEmpty()) {
      throw new ApiException(HttpStatus.UNAUTHORIZED, "you are not authorized", Arrays.asList("UNAUTHORIZED"));
    }

    return opUser.get();
  }
}
