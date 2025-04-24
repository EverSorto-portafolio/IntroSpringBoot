package com.introduccion.springnott.web.springboot_web.controllers.models.DTO;

public class ParamDTO {
private String mensaje;


public ParamDTO() {
    // Constructor por defecto
}
public ParamDTO(String mensaje) {
    this.mensaje = mensaje;
}

public String getMensaje() {
    return mensaje;
}

public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
}

}
