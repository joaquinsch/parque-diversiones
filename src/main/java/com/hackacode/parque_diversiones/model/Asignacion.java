package com.hackacode.parque_diversiones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}
