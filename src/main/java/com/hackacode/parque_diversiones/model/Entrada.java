package com.hackacode.parque_diversiones.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Entrada {
    private Long id_entrada;
    private Juego juego;
    private LocalDateTime fecha_hora;
}
