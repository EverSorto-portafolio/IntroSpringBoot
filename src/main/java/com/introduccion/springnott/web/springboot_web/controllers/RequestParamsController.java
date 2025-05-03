package com.introduccion.springnott.web.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.introduccion.springnott.web.springboot_web.controllers.models.DTO.ParamDTO;
import com.introduccion.springnott.web.springboot_web.controllers.models.DTO.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @Value("${config.mensaje}")
    private String mensaje;
    @Value("${config.direccion}")
    private String direccion;
    @Value("${config.edad}")
    private int edad;
    @Value("${config.saludo}")
    private String saludo;
   // @Value("${config.Arr}")
   // private String[] lista;


    @GetMapping("/foot")
    public ParamDTO foot(
        @RequestParam(required = false, defaultValue = "Sin mensaje")String mensaje){
        ParamDTO param = new ParamDTO(mensaje);
        param.setMensaje(mensaje);
        return param;
    }

    @GetMapping("/muchos")
    public ParamDTO 
    muchos(
    @RequestParam( name = "m" , defaultValue= "ningun mensaje") String mensaje,  
    @RequestParam(name = "d", defaultValue = "ninguna direccion") String direccion)
    {      
        ParamDTO params = new ParamDTO(mensaje, direccion);
        return params;
    }
@GetMapping("/servelet")
public ParamDTO getMethodName(HttpServletRequest request) {

    ParamDTO param = 
    new ParamDTO(request.getParameter("mensaje"), request.getParameter("direccion"));
    return param;
}

@GetMapping("/try")
public ParamDTO errores (HttpServletRequest request) {
 
    try{
    ParamDTO param = new ParamDTO(
    request.getParameter("mensaje"),
     request.getParameter("direccion"), 
     request.getParameter("edad") 
     != null ? Integer.parseInt(request.getParameter("edad")) : 0
     );
     return param;
    }catch ( NumberFormatException ex) {
        System.out.println("Error: " + ex.getMessage());
        return null;
    }
    
    
}

@GetMapping("/ejemplo/{variable}")
public ParamDTO ejemplo(@PathVariable String variable){
    ParamDTO param = new ParamDTO();
    param.setMensaje(variable);
    return param;
}

@GetMapping("/ejemplo/{variable}/{variable2}")
public ParamDTO ejemplo2(
    @PathVariable String variable, 
    @PathVariable String variable2){
    ParamDTO param = new ParamDTO();
    param.setMensaje(variable);
    param.setDireccion(variable2);
    return param;

    }


@PostMapping("/usopost")
public ParamDTO usoRequest (@RequestBody ParamDTO user) {
    user.setMensaje(user.getMensaje().toUpperCase());
    user.setDireccion(user.getDireccion().toUpperCase());
    user.setEdad(user.getEdad() + 1);
    return user;
}

@GetMapping("/inyectar")
public Map<String, Object> inyectar(@Value("${config.Arr}")
String[] lista){
 Map<String, Object> json = new HashMap<>();
    json.put("mensaje", mensaje);
    json.put("direccion", direccion);
    json.put("edad", edad);
    json.put("lista", lista);
    json.put("saludo", saludo);
    return json;
}
}
