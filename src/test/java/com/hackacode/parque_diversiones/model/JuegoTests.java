package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JuegoTests {

    @Test
    public void deberiaCrearseConId() {
        Juego juego = new Juego();
        juego.setId_juego(1L);
        Assertions.assertEquals(1L, juego.getId_juego());
    }
}
