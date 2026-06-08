package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.model.Juego;
import com.hackacode.parque_diversiones.repository.JuegoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
public class JuegoServiceTests {

    @Mock
    private JuegoRepository juegoRepository;

    //@InjectMocks
    //private JuegoService juegoService;

    Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
        juego.setId_juego(1L);
        juego.setHora_inicio(LocalTime.of(14, 0));
        juego.setHora_fin(LocalTime.of(15, 0));
    }

}
