package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class JuegoTests {

    Juego juego = new Juego();

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
}
