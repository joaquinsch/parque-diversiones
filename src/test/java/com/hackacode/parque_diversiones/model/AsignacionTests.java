package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AsignacionTests {

    Asignacion asignacion;

    @BeforeEach
    void setUp() {
        asignacion = new Asignacion();
    }

    @Test
    public void deberiaCrearseConId() {
        asignacion.setId_asignacion(1L);
        Assertions.assertEquals(1L, asignacion.getId_asignacion());
    }
}
