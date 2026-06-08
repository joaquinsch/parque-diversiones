package com.hackacode.parque_diversiones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter @Setter
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_juego;
    private String nombre;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    @OneToMany(mappedBy = "juego")
    private List<Asignacion> asignaciones;
    @OneToMany(mappedBy = "juego")
    private List<Entrada> entradas;


}
