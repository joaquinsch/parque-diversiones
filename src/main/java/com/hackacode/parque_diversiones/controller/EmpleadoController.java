package com.hackacode.parque_diversiones.controller;

import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;
import com.hackacode.parque_diversiones.service.IEmpleadoJuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final IEmpleadoJuegoService empleadoJuegoService;

    public EmpleadoController(IEmpleadoJuegoService empleadoJuegoService) {
        this.empleadoJuegoService = empleadoJuegoService;
    }

    @PostMapping("/juego")
    public ResponseEntity<EmpleadoJuegoResponseDTO> crearEmpleadoJuego(@RequestBody EmpleadoJuegoDTO empleadoJuegoDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empleadoJuegoService.guardarEmpleadoJuego(empleadoJuegoDTO));
    }
}
