package com.hackacode.parque_diversiones.controller;

import com.hackacode.parque_diversiones.dto.JuegoDTO;
import com.hackacode.parque_diversiones.exceptions.HorarioInvalidoError;
import com.hackacode.parque_diversiones.service.IJuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/juegos")
public class JuegoController {
    private final IJuegoService juegoService;

    public JuegoController(IJuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping
    public ResponseEntity<?> guardarJuego(@RequestBody JuegoDTO juegoDTO) {
        try {
            return new ResponseEntity<>(juegoService.guardarJuego(juegoDTO), HttpStatus.CREATED);

        } catch (HorarioInvalidoError e) {
            return ResponseEntity.
                    badRequest()
                    .body(Map.of("mensaje", e.getMessage()));
        }
    }
}
