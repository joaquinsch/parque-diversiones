package com.hackacode.parque_diversiones.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Empleado {
    private Long id_empleado;
    private String nombre;
}
