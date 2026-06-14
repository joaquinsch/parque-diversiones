package com.hackacode.parque_diversiones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Asignacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoJuego empleado;
}
