package com.hackacode.parque_diversiones.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter @Setter
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_juego;
    private String nombre;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private List<Asignacion> asignaciones;
    private List<Entrada> entradas;


}
