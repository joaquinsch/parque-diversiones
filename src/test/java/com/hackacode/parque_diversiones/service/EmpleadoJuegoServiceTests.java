package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.AsignacionDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;
import com.hackacode.parque_diversiones.exceptions.AsignacionDuplicadaError;
import com.hackacode.parque_diversiones.exceptions.EmpleadoNoEncontradoError;
import com.hackacode.parque_diversiones.exceptions.JuegoNoEncontradoError;
import com.hackacode.parque_diversiones.model.Asignacion;
import com.hackacode.parque_diversiones.model.EmpleadoJuego;
import com.hackacode.parque_diversiones.model.Juego;
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


import java.util.ArrayList;
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
    List<Asignacion> asignaciones;

    @BeforeEach
    void setUp() {
        asignaciones = new ArrayList<>();
        Asignacion as1 = new Asignacion();
        Juego juego1 = new Juego();
        juego1.setId_juego(1L);
        as1.setJuego(juego1);

        Asignacion as2 = new Asignacion();
        Juego juego2 = new Juego();
        juego2.setId_juego(2L);
        as2.setJuego(juego2);

        asignaciones.add(as1);
        asignaciones.add(as2);
    }

    @Test
    public void deberiaDarErrorSiNoEncuentraUnJuego() {
        empleado = new EmpleadoJuegoDTO();
        AsignacionDTO as1 = new AsignacionDTO();
        Juego juego = new Juego();
        juego.setId_juego(8L);
        as1.setId_juego(juego.getId_juego());
        empleado.setAsignaciones(List.of(as1));

        Mockito.when(juegoRepository.findById(as1.getId_juego()))
                .thenReturn(Optional.empty());

        JuegoNoEncontradoError exception = assertThrows(
                JuegoNoEncontradoError.class,
                () -> empleadoJuegoService.guardarEmpleadoJuego(empleado)
        );
        Assertions.assertEquals("El juego con id 8 no fue encontrado", exception.getMessage());
    }

    @Test
    public void deberiaDarErrorSiPasaDosVecesElMismoIdJuegoAlCrearUnEmpleado() {
        empleado = new EmpleadoJuegoDTO();
        AsignacionDTO as1 = new AsignacionDTO();
        Juego juego = new Juego();
        juego.setId_juego(8L);
        as1.setId_juego(juego.getId_juego());
        empleado.setAsignaciones(List.of(as1,as1));

        AsignacionDuplicadaError exception = assertThrows(
                AsignacionDuplicadaError.class,
                () -> empleadoJuegoService.guardarEmpleadoJuego(empleado)
        );
        Assertions.assertEquals("Se enviaron juegos duplicados en las asignaciones", exception.getMessage());
    }

    @Test
    public void deberiaEncontrarAlEmpleadoPorId() {
        EmpleadoJuego emple = new EmpleadoJuego();
        emple.setId_empleado(3L);
        emple.setNombre("jose");
        emple.setAsignaciones(asignaciones);
        Mockito.when(empleadoJuegoRepository.findById(emple.getId_empleado()))
                .thenReturn(Optional.of(emple));
        Mockito.when(empleadoJuegoRepository.obtenerJuegosDelEmpleado(emple.getId_empleado()))
                .thenReturn(List.of(1L,2L));

        EmpleadoJuegoResponseDTO encontrado = empleadoJuegoService.buscarEmpleado(emple.getId_empleado());
        Assertions.assertNotNull(encontrado);
        Assertions.assertEquals(3L, encontrado.getId_empleado());
        Assertions.assertEquals("jose", encontrado.getNombre());
        Assertions.assertEquals(1L, encontrado.getAsignaciones().get(0).getId_juego());
        Assertions.assertEquals(2L, encontrado.getAsignaciones().get(1).getId_juego());
    }

    @Test
    public void deberiaDarErrorSiNoEncuentraAlEmpleadoBuscado() {
        EmpleadoJuego emple = new EmpleadoJuego();
        emple.setId_empleado(3L);
        emple.setNombre("jose");
        Mockito.when(empleadoJuegoRepository.findById(emple.getId_empleado()))
                .thenThrow(new EmpleadoNoEncontradoError("No se encontró al empleado con id " + emple.getId_empleado()));
        EmpleadoNoEncontradoError exception = assertThrows(
                EmpleadoNoEncontradoError.class,
                () -> empleadoJuegoService.buscarEmpleado(emple.getId_empleado())
        );
        Assertions.assertEquals("No se encontró al empleado con id " + emple.getId_empleado(), exception.getMessage());

    }
}
