package com.introduccion.springnott.web.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.introduccion.springnott.web.springboot_web.controllers.models.User;
import com.introduccion.springnott.web.springboot_web.controllers.models.DTO.UserDTO;


@RestController
@RequestMapping("/api")
public class UserRestController {

  @GetMapping("/detalles")
  public UserDTO detalles() {
    User user = new User("Ever", "Sorto");
    UserDTO userDto = new UserDTO();
    userDto.setUser(user);
    userDto.setTitle("User Details");
    return userDto;
  }
}
