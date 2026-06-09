package com.hackacode.parque_diversiones.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EmpleadoJuegoResponseDTO {
    private Long id_empleado;
    private String nombre;
    private String apellido;
    private String dni;
    private List<AsignacionDTO> asignaciones;

}
