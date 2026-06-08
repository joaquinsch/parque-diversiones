package com.hackacode.parque_diversiones.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.hackacode.parque_diversiones.dto.JuegoDTO;
import com.hackacode.parque_diversiones.dto.JuegoResponseDTO;
import com.hackacode.parque_diversiones.service.IJuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalTime;

@WebMvcTest(JuegoController.class)
public class JuegoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IJuegoService juegoService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void deberiaGuardarElJuego() throws Exception {
        JuegoDTO juegoDTO = new JuegoDTO();
        juegoDTO.setNombre("montania verde");
        juegoDTO.setHora_inicio(LocalTime.of(14, 0));
        juegoDTO.setHora_fin(LocalTime.of(15, 0));

        JuegoResponseDTO respuesta = new JuegoResponseDTO();
        respuesta.setId_juego(1L);
        respuesta.setNombre("montania verde");
        respuesta.setHora_inicio(LocalTime.of(14, 0));
        respuesta.setHora_fin(LocalTime.of(15, 0));

        Mockito.when(juegoService.guardarJuego(Mockito.any(JuegoDTO.class))).thenReturn(respuesta);
        mockMvc.perform(MockMvcRequestBuilders.post("/juegos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(juegoDTO))
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_juego").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("montania verde"));
    }
}
