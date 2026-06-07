package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CompradorTests {

    Comprador comprador;

    @BeforeEach
    void setUp() {
        comprador = new Comprador();
    }

    @Test
    public void compradorSeCreaConId() {
        comprador.setId_comprador(1L);
        Assertions.assertEquals(1L, comprador.getId_comprador());
    }

    @Test
    public void deberiaCreareseConListaDeEntradas() {
        List<Entrada> entradas = new ArrayList<>();
        entradas.add(new Entrada());
        comprador.setEntradas(entradas);
        Assertions.assertNotNull(comprador.getEntradas());
        Assertions.assertEquals(1, comprador.getEntradas().size());
    }
}
