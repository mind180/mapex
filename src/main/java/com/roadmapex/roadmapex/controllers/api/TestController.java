package com.roadmapex.roadmapex.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  TestController() {}

  @GetMapping
  public String testRequest(@RequestParam(value="param", defaultValue = "test") String param) {
    return "Oh shit. He we go agai";
  }
}
