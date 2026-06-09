package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.JuegoDTO;
import com.hackacode.parque_diversiones.dto.JuegoResponseDTO;
import com.hackacode.parque_diversiones.exceptions.HorarioInvalidoError;
import com.hackacode.parque_diversiones.model.Juego;
import com.hackacode.parque_diversiones.repository.JuegoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
public class JuegoServiceTests {

    @Mock
    private JuegoRepository juegoRepository;

    @InjectMocks
    private JuegoService juegoService;

    Juego juego;

    @BeforeEach
    void setUp() {
        juego = new Juego();
        juego.setId_juego(1L);
        juego.setNombre("montania verde");
        juego.setHora_inicio(LocalTime.of(14, 0));
        juego.setHora_fin(LocalTime.of(15, 0));
    }

    @Test
    public void deberiaGuardarUnJuegoConSusDatosLlamandoAlRepository() {
        Mockito.when(juegoRepository.save(Mockito.any(Juego.class))).thenReturn(juego);
        JuegoDTO juegoDTO = new JuegoDTO();
        juegoDTO.setNombre("montania verde");
        juegoDTO.setHora_inicio(LocalTime.of(14, 0));
        juegoDTO.setHora_fin(LocalTime.of(15, 0));

        JuegoResponseDTO guardado = juegoService.guardarJuego(juegoDTO);
        Assertions.assertNotNull(guardado.getId_juego());
        Mockito.verify(juegoRepository, Mockito.times(1)).save(Mockito.any(Juego.class));
    }

    @Test
    public void deberiaDarErrorSiIntentaCrearUnJuegoConHorarioInicioYFinInvalidos() {
        JuegoDTO juegoMalCreado = new JuegoDTO();
        juegoMalCreado.setNombre("montania verde");
        juegoMalCreado.setHora_inicio(LocalTime.of(15, 0));
        juegoMalCreado.setHora_fin(LocalTime.of(12, 0));
        Assertions.assertThrows(HorarioInvalidoError.class,
                () -> juegoService.guardarJuego(juegoMalCreado));
    }
}
