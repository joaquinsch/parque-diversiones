package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JuegoTests {

    Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
    }

    @Test
    public void deberiaCrearseConId() {
        juego.setId_juego(1L);
        Assertions.assertEquals(1L, juego.getId_juego());
    }

    @Test
    public void deberiaCrearseConHorarioDeInicio() {
        juego.setHora_inicio(LocalTime.of(14,0));
        Assertions.assertEquals(LocalTime.of(14,0), juego.getHora_inicio());
    }

    @Test
    public void deberiaCrearseConHorarioDeFin() {
        juego.setHora_fin(LocalTime.of(15,0));
        Assertions.assertEquals(LocalTime.of(15,0), juego.getHora_fin());
    }

    @Test
    @DisplayName("Debería crearse con lista de asignaciones")
    public void deberiaCreareseConListaDeAsignaciones() {
        List<Asignacion> asignaciones = new ArrayList<>();
        asignaciones.add(new Asignacion());
        juego.setAsignaciones(asignaciones);
        Assertions.assertNotNull(juego.getAsignaciones());
        Assertions.assertEquals(1, juego.getAsignaciones().size());
    }

    @Test
    public void deberiaCreareseConListaDeEntradas() {
        List<Entrada> entradas = new ArrayList<>();
        entradas.add(new Entrada());
        juego.setEntradas(entradas);
        Assertions.assertNotNull(juego.getEntradas());
        Assertions.assertEquals(1, juego.getEntradas().size());
    }
}
