package com.hackacode.parque_diversiones.controller;

import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;
import com.hackacode.parque_diversiones.service.IEmpleadoJuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id_empleado}")
    public ResponseEntity<EmpleadoJuegoResponseDTO> buscarEmpleado(@PathVariable Long id_empleado) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empleadoJuegoService.buscarEmpleado(id_empleado));
    }

    @PutMapping("/{id_empleado}")
    public ResponseEntity<EmpleadoJuegoResponseDTO> editarEmpleadoJuego(@PathVariable Long id_empleado, @RequestBody
    EmpleadoJuegoDTO empleadoJuegoDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empleadoJuegoService.editarEmpleado(id_empleado, empleadoJuegoDTO));
    }

}
