package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoTests {
    Empleado empleado;

    @BeforeEach
    void setUp() {
        empleado = new EmpleadoJuego();
    }

    @Test
    public void deberiaCrearseConId() {
        empleado.setId_empleado(1L);
        Assertions.assertEquals(1L, empleado.getId_empleado());
    }

    @Test
    public void deberiaCrearseConNombre() {
        empleado.setNombre("carlos");
        Assertions.assertEquals("carlos", empleado.getNombre());
    }

    @Test
    public void deberiaTenerUnaListaDeAsignaciones() {
        Asignacion asignacion = new Asignacion();
        asignacion.setEmpleado(empleado);

        List<Asignacion> asignaciones = new ArrayList<>();
        asignaciones.add(asignacion);
        empleado.setAsignaciones(asignaciones);
        Assertions.assertNotNull(empleado.getAsignaciones());
        Assertions.assertEquals(1, empleado.getAsignaciones().size());
    }
}
