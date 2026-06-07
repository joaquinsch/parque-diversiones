package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpleadoTests {

    @Test
    public void deberiaCrearseConNombre() {
        Empleado empleado = new EmpleadoJuego();
        empleado.setNombre("carlos");
        Assertions.assertEquals("carlos", empleado.getNombre());
    }
}
