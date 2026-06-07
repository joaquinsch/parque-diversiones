package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class AsignacionTests {

    Asignacion asignacion;
    Juego juego;
    Empleado empleado;

    @BeforeEach
    void setUp() {
        asignacion = new Asignacion();
        juego = new Juego();
        juego.setId_juego(1L);
        juego.setHora_inicio(LocalTime.of(14,0));
        juego.setHora_fin(LocalTime.of(18,0));
    }

    @Test
    public void deberiaCrearseConId() {
        asignacion.setId_asignacion(1L);
        Assertions.assertEquals(1L, asignacion.getId_asignacion());
    }

    @Test
    public void deberiaCrearseConUnJuegoAsociado() {
        asignacion.setJuego(juego);
        Assertions.assertNotNull(asignacion.getJuego());
        Assertions.assertEquals(asignacion.getJuego().getHora_fin(), LocalTime.of(18,0));
    }

    @Test
    public void deberiaCrearseConUnEmpleadoAsociado() {
        empleado = new EmpleadoJuego();
        empleado.setNombre("carlos");
        asignacion.setEmpleado(empleado);
        Assertions.assertNotNull(asignacion.getEmpleado());
        Assertions.assertEquals("carlos", asignacion.getEmpleado().getNombre());
    }
}
