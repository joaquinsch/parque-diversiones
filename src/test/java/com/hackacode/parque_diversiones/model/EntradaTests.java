package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EntradaTests {

    Entrada entrada;

    @BeforeEach
    void setUp() {
        entrada = new Entrada();
    }

    @Test
    public void deberiaCrearseConId() {
        entrada.setId_entrada(1L);
        Assertions.assertEquals(1L, entrada.getId_entrada());
    }
}
