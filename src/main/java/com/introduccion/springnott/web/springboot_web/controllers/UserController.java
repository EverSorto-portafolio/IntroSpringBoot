package com.introduccion.springnott.web.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

  @GetMapping("/detalles")
  public String detalles(Model model) {
    model.addAttribute
    ("title", "Hola desde Spring Boot");
    model.addAttribute
    ("nombre", "Ever Sorto");
    model.addAttribute
    ("apellido", "Ayala");
    return "detalles";
  }
  
}
