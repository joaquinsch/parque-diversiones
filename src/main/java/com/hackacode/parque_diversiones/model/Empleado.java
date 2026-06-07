package com.hackacode.parque_diversiones.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public abstract class Empleado {
    private Long id_empleado;
    private String nombre;
    private String apellido;
    private String dni;
    private List<Asignacion> asignaciones;
}
