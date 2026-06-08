package com.hackacode.parque_diversiones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrada;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;
    private LocalDateTime fecha_hora;
}
