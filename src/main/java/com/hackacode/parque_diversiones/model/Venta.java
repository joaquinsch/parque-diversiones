package com.hackacode.parque_diversiones.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Venta {
    private Long id_venta;
    private Entrada entrada;
    private LocalDateTime fecha;
}

