package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.JuegoDTO;
import com.hackacode.parque_diversiones.dto.JuegoResponseDTO;

public interface IJuegoService {
    JuegoResponseDTO guardarJuego(JuegoDTO juego);
}
