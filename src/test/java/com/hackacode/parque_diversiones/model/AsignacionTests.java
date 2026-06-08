package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AsignacionTests {

    Asignacion asignacion;
    Juego juego;
    EmpleadoJuego empleado;

    @BeforeEach
    void setUp() {
        asignacion = new Asignacion();
        juego = new Juego();
        juego.setId_juego(1L);
        juego.setNombre("montaniaroja");
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

    @Test
    public void unaListaDeAsignacionesDeberiaPertenecerAUnJuegoYEmpleado() {
        empleado = new EmpleadoJuego();
        empleado.setNombre("maria");

        Asignacion asignacion = new Asignacion();
        asignacion.setEmpleado(empleado);
        asignacion.setJuego(juego);

        List<Asignacion> asignaciones = new ArrayList<>();
        asignaciones.add(asignacion);

        juego.setAsignaciones(asignaciones);
        empleado.setAsignaciones(asignaciones);

        Assertions.assertNotNull(empleado.getAsignaciones());
        Assertions.assertNotNull(juego.getAsignaciones());

        Assertions.assertEquals(1, empleado.getAsignaciones().size());
        Assertions.assertEquals(1, juego.getAsignaciones().size());
        Assertions.assertEquals(LocalTime.of(14,0), juego.getAsignaciones().get(0).getJuego().getHora_inicio());
        Assertions.assertEquals("maria", empleado.getAsignaciones().get(0).getEmpleado().getNombre());
    }

    @Test
    public void unMismoEmpleadoPerteneceAAsignacionesDeDistintosJuegos() {
        empleado = new EmpleadoJuego();
        empleado.setNombre("maria");

        asignacion.setEmpleado(empleado);
        asignacion.setJuego(juego);

        Juego juego2 = new Juego();
        juego2.setNombre("montaniaverde");

        Asignacion asignacion2 = new Asignacion();
        asignacion2.setEmpleado(empleado);
        asignacion2.setJuego(juego2);

        List<Asignacion> asignaciones = new ArrayList<>();
        asignaciones.add(asignacion);
        List<Asignacion> asignaciones2 = new ArrayList<>();
        asignaciones2.add(asignacion2);

        juego.setAsignaciones(asignaciones);
        juego2.setAsignaciones(asignaciones2);
        List<Asignacion> asignacionesDelEmpleado = new ArrayList<>();
        asignacionesDelEmpleado.add(asignacion);
        asignacionesDelEmpleado.add(asignacion2);
        empleado.setAsignaciones(asignacionesDelEmpleado);

        Assertions.assertNotNull(empleado.getAsignaciones());
        Assertions.assertNotNull(juego.getAsignaciones());
        Assertions.assertNotNull(juego2.getAsignaciones());

        Assertions.assertEquals(2, empleado.getAsignaciones().size());
        Assertions.assertEquals(1, juego.getAsignaciones().size());
        Assertions.assertEquals(1, juego2.getAsignaciones().size());

        Assertions.assertEquals("montaniaroja", empleado.getAsignaciones().get(0).getJuego().getNombre());
        Assertions.assertEquals("montaniaverde", empleado.getAsignaciones().get(1).getJuego().getNombre());
    }
}
