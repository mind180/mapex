package com.roadmapex.roadmapex.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
  public HomeController() {
  }

  @GetMapping(value = {"/", "/library/**", "/canvas/**"})
  public String index() {
    return "forward:/";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
