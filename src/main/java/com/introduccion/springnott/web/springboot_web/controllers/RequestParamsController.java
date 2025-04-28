package com.introduccion.springnott.web.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.introduccion.springnott.web.springboot_web.controllers.models.DTO.ParamDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
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

}
