package com.introduccion.springnott.web.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.introduccion.springnott.web.springboot_web.controllers.models.DTO.ParamDTO;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foot")
    public ParamDTO foot(@RequestParam
    (required = false, defaultValue = "Sin mensaje") String mensaje){
        ParamDTO param = new ParamDTO(mensaje );
        return param;
    }

}
