package com.introduccion.springnott.web.springboot_web.controllers.models.DTO;

public class ParamDTO {
private String mensaje;
private String direccion;

public ParamDTO() {
    // Constructor por defecto
}
public ParamDTO(String mensaje) {
    this.mensaje = mensaje;
}

public ParamDTO(String mensaje, String direccion) {
    this.mensaje = mensaje;
    this.direccion = direccion;
}
public String getMensaje() {
    return mensaje;
}

public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
}
public String getDireccion() {
    return direccion;
}
public void setDireccion(String direccion) {
    this.direccion = direccion;
}

}