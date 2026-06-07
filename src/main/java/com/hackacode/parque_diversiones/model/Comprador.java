package com.hackacode.parque_diversiones.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Comprador {
    private Long id_comprador;
    private List<Entrada> entradas;
}
