package com.roadmapex.roadmapex.controllers.api;

import com.roadmapex.roadmapex.config.exceptions.ApiException;
import com.roadmapex.roadmapex.dto.UserDto;
import com.roadmapex.roadmapex.model.User;
import com.roadmapex.roadmapex.repository.canvas.UserRepository;
import com.roadmapex.roadmapex.services.users.UserDetailsImpl;
import com.roadmapex.roadmapex.services.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

  private UserService userService;
  private UserRepository userRepository;

  public UserController(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository = userRepository;
  }

  @GetMapping("{userId}")
  public UserDto getUser(@PathVariable String userId) {
    Optional<User> opUser = userRepository.getUserById(UUID.fromString(userId));

    if (opUser.isEmpty()) {
      throw new ApiException(HttpStatus.NOT_FOUND, "User not found", Arrays.asList("user id"));
    }

    return new UserDto(opUser.get());
  }

  @GetMapping("/you")
  public UserDto getYou() {
    UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return new UserDto(user.getUsername(), "", "", "");
  }

}
