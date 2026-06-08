package com.hackacode.parque_diversiones.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
public class JuegoDTO {
    private String nombre;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
}
