package com.hackacode.parque_diversiones.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HorarioInvalidoError.class)
    public ResponseEntity<Map<String, String>> handleHorarioInvalidoError(HorarioInvalidoError e) {
        return ResponseEntity
                .badRequest()
                .body((Map.of("mensaje", e.getMessage())));
    }

    @ExceptionHandler(JuegoNoEncontradoError.class)
    public ResponseEntity<Map<String, String>> handleJuegoNoEncontradoError(JuegoNoEncontradoError e) {
        return ResponseEntity
                .badRequest()
                .body((Map.of("mensaje", e.getMessage())));
    }

    @ExceptionHandler(AsignacionDuplicadaError.class)
    public ResponseEntity<Map<String, String>> handleAsignacionDuplicadaError(AsignacionDuplicadaError e){
        return ResponseEntity
                .badRequest()
                .body((Map.of("mensaje", e.getMessage())));
    }
}
