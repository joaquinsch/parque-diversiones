package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoTests {
    EmpleadoJuego empleadoJuego;

    @BeforeEach
    void setUp() {
        empleadoJuego = new EmpleadoJuego();
    }

    @Test
    public void deberiaCrearseConId() {
        empleadoJuego.setId_empleado(1L);
        Assertions.assertEquals(1L, empleadoJuego.getId_empleado());
    }

    @Test
    public void deberiaCrearseConNombre() {
        empleadoJuego.setNombre("carlos");
        Assertions.assertEquals("carlos", empleadoJuego.getNombre());
    }

    @Test
    public void deberiaCrearseConApellido() {
        empleadoJuego.setApellido("gomez");
        Assertions.assertEquals("gomez", empleadoJuego.getApellido());
    }

    @Test
    public void deberiaCrearseConDni() {
        empleadoJuego.setDni("11223344");
        Assertions.assertEquals("11223344", empleadoJuego.getDni());
    }

    @Test
    public void deberiaTenerUnaListaDeAsignaciones() {
        Asignacion asignacion = new Asignacion();
        asignacion.setEmpleado(empleadoJuego);

        List<Asignacion> asignaciones = new ArrayList<>();
        asignaciones.add(asignacion);
        empleadoJuego.setAsignaciones(asignaciones);
        Assertions.assertNotNull(empleadoJuego.getAsignaciones());
        Assertions.assertEquals(1, empleadoJuego.getAsignaciones().size());
    }

    @Test
    public void empleadoPuedeSerEmpleadoAdministrativo() {
        Empleado empleAdmin = new EmpleadoAdministrativo();
        Assertions.assertInstanceOf(EmpleadoAdministrativo.class, empleAdmin);
    }
}
