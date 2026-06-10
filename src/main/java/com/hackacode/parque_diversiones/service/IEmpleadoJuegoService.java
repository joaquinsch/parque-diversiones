package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;
import com.hackacode.parque_diversiones.model.EmpleadoJuego;

public interface IEmpleadoJuegoService {
    EmpleadoJuegoResponseDTO guardarEmpleadoJuego(EmpleadoJuegoDTO empleadoDTO);
    EmpleadoJuego buscarEmpleado(Long id_empleado);
}
