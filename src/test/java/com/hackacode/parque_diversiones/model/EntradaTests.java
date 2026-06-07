package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class EntradaTests {

    Entrada entrada;
    Juego juego;

    @BeforeEach
    void setUp() {
        entrada = new Entrada();
        juego = new Juego();
        juego.setId_juego(1L);
        juego.setHora_inicio(LocalTime.of(14,0));
        juego.setHora_fin(LocalTime.of(18,0));
    }

    @Test
    public void deberiaCrearseConId() {
        entrada.setId_entrada(1L);
        Assertions.assertEquals(1L, entrada.getId_entrada());
    }

    @Test
    public void deberiaCrearseConUnJuegoAsociado() {
        entrada.setJuego(juego);
        Assertions.assertNotNull(entrada.getJuego());
        Assertions.assertEquals(entrada.getJuego().getHora_fin(), LocalTime.of(18,0));
    }

    @Test
    public void deberiaCrearseConFechaYHorarioDeUso() {
        entrada.setFecha_hora(LocalDateTime.of(LocalDate.of(2026, 6, 8), LocalTime.of(14,0)));
        Assertions.assertEquals(LocalDateTime.of(LocalDate.of(2026, 6, 8), LocalTime.of(14,0)),
                entrada.getFecha_hora());
    }
}
