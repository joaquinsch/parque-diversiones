package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.JuegoDTO;
import com.hackacode.parque_diversiones.dto.JuegoResponseDTO;
import com.hackacode.parque_diversiones.exceptions.HorarioInvalidoError;
import com.hackacode.parque_diversiones.model.Juego;
import com.hackacode.parque_diversiones.repository.JuegoRepository;
import org.springframework.stereotype.Service;

@Service
public class JuegoService implements IJuegoService {

    private final JuegoRepository juegoRepository;

    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    public JuegoResponseDTO guardarJuego(JuegoDTO juego) {
        Juego aGuardar = new Juego();
        aGuardar.setNombre(juego.getNombre());
        aGuardar.setHora_inicio(juego.getHora_inicio());
        aGuardar.setHora_fin(juego.getHora_fin());
        validarHorarioDeJuego(juego);
        Juego guardado = juegoRepository.save(aGuardar);

        JuegoResponseDTO respuesta = new JuegoResponseDTO();
        respuesta.setId_juego(guardado.getId_juego());
        respuesta.setNombre(guardado.getNombre());
        respuesta.setHora_inicio(guardado.getHora_inicio());
        respuesta.setHora_fin(guardado.getHora_fin());
        return respuesta;
    }

    private void validarHorarioDeJuego(JuegoDTO juegoDTO) {
        if (juegoDTO.getHora_inicio().isAfter(juegoDTO.getHora_fin())) {
            throw new HorarioInvalidoError("Los horarios de inicio y fin son inválidos");
        }
    }
}
