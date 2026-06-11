package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;

public interface IEmpleadoJuegoService {
    EmpleadoJuegoResponseDTO guardarEmpleadoJuego(EmpleadoJuegoDTO empleadoDTO);
    EmpleadoJuegoResponseDTO buscarEmpleado(Long id_empleado);
}
