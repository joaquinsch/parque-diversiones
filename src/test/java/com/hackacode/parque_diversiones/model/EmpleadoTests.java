package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTests {
    Empleado empleado;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void deberiaCrearseConId() {
        empleado = new EmpleadoJuego();
        empleado.setId_empleado(1L);
        Assertions.assertEquals(1L, empleado.getId_empleado());
    }

    @Test
    public void deberiaCrearseConNombre() {
        Empleado empleado = new EmpleadoJuego();
        empleado.setNombre("carlos");
        Assertions.assertEquals("carlos", empleado.getNombre());
    }
}
