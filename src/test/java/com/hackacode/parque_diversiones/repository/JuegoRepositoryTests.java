package com.hackacode.parque_diversiones.repository;

import com.hackacode.parque_diversiones.model.Juego;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalTime;

@DataJpaTest
public class JuegoRepositoryTests {

    @Autowired
    private JuegoRepository juegoRepository;

    Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
        juego.setNombre("montaniaverde");
        juego.setHora_inicio(LocalTime.of(14, 0));
        juego.setHora_fin(LocalTime.of(15, 0));
    }

    @Test
    void deberiaGuardarUnJuego() {
        Juego guardado = juegoRepository.save(juego);
        Assertions.assertNotNull(guardado.getId_juego());
    }

}
