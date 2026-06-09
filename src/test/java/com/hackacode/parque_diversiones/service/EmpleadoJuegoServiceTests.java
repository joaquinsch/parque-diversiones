package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.AsignacionDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.exceptions.JuegoNoEncontradoError;
import com.hackacode.parque_diversiones.repository.EmpleadoJuegoRepository;
import com.hackacode.parque_diversiones.repository.JuegoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class EmpleadoJuegoServiceTests {

    @Mock
    private EmpleadoJuegoRepository empleadoJuegoRepository;

    @Mock
    private JuegoRepository juegoRepository;

    @InjectMocks
    private EmpleadoJuegoService empleadoJuegoService;

    EmpleadoJuegoDTO empleado;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void deberiaDarErrorSiNoEncuentraUnJuego() {
        empleado = new EmpleadoJuegoDTO();
        AsignacionDTO as1 = new AsignacionDTO();
        as1.setId_juego(8L);
        empleado.setAsignaciones(List.of(as1));

        Mockito.when(juegoRepository.findById(as1.getId_juego()))
                .thenReturn(Optional.empty());

        JuegoNoEncontradoError exception = assertThrows(
                JuegoNoEncontradoError.class,
                () -> empleadoJuegoService.guardarEmpleadoJuego(empleado)
        );
        Assertions.assertEquals("El juego con id 8 no fue encontrado", exception.getMessage());
    }
}
