package com.hackacode.parque_diversiones.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackacode.parque_diversiones.dto.AsignacionDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;
import com.hackacode.parque_diversiones.model.Juego;
import com.hackacode.parque_diversiones.service.IEmpleadoJuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(EmpleadoController.class)
public class EmpleadoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private IEmpleadoJuegoService empleadoJuegoService;

    Juego juego;
    Juego juego2;

    @BeforeEach
    void setUp() {
        juego = new Juego();
        juego.setId_juego(1L);
        juego.setNombre("montania");

        juego2 = new Juego();
        juego2.setId_juego(2L);
        juego.setNombre("montania roja");
    }

    @Test
    public void deberiaGuardarElEmpleadoDeJuegoYSusAsignaciones() throws Exception {
        EmpleadoJuegoDTO empleadoJuegoDTO = new EmpleadoJuegoDTO();
        empleadoJuegoDTO.setNombre("carlos");
        empleadoJuegoDTO.setApellido("gomez");
        empleadoJuegoDTO.setDni("1122223333");
        List<AsignacionDTO> asignaciones = new ArrayList<>();
        AsignacionDTO as1 = new AsignacionDTO();
        as1.setId_juego(juego.getId_juego());
        AsignacionDTO as2 = new AsignacionDTO();
        as2.setId_juego(juego2.getId_juego());
        asignaciones.add(as1);
        asignaciones.add(as2);
        empleadoJuegoDTO.setAsignaciones(asignaciones);

        EmpleadoJuegoResponseDTO devuelto = new EmpleadoJuegoResponseDTO();
        devuelto.setId_empleado(1L);
        devuelto.setNombre("carlos");
        devuelto.setApellido("gomez");
        devuelto.setDni("1122223333");
        devuelto.setAsignaciones(empleadoJuegoDTO.getAsignaciones());

        Mockito.when(empleadoJuegoService.guardarEmpleadoJuego(Mockito.any(EmpleadoJuegoDTO.class))).thenReturn(devuelto);

        mockMvc.perform(MockMvcRequestBuilders.post("/empleados/juego")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(empleadoJuegoDTO))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("carlos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.apellido").value("gomez"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dni").value("1122223333"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.asignaciones[0].id_juego").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.asignaciones[1].id_juego").value(2L));

    }

    @Disabled
    @Test
    public void deberiaDarErrorJuegoNoEncontradoSiSePoneUnIdJuegoInexistente(){

    }

    @Disabled
    @Test
    public void deberiaDarErrorSiIntentaAsignarEmpleadoADosOMasVecesElMismoIdJuego(){

    }


}
