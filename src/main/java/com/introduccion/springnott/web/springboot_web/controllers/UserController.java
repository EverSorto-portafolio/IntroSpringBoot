package com.introduccion.springnott.web.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.introduccion.springnott.web.springboot_web.controllers.models.User;
import com.introduccion.springnott.web.springboot_web.controllers.models.DTO.UserDTO;


@Controller
public class UserController {
@GetMapping("/detalles")
public String getMethodName(Model model) {
   
    User  identificarUsuario = 
    new User("Ever", "Sorto");
   
    UserDTO dtoEmailUserTitleCorreo = new UserDTO(
    "Titulo desde DTO",
    identificarUsuario,
    "correo@servidor");

    model.addAttribute(
        "userDTO", 
        dtoEmailUserTitleCorreo);
    return "detalles2";
}

@GetMapping("/lista")
public String lista(ModelMap model){
    List<User> user = new ArrayList<>();
    user.add(new User("Ever", "Sorto"));
    model.addAttribute("user", user);
    model.addAttribute("title", "Lista de usuarios");
    return "lista"; 
}
}
