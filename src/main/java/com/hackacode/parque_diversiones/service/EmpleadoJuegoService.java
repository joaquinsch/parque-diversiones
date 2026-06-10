package com.hackacode.parque_diversiones.service;

import com.hackacode.parque_diversiones.dto.AsignacionDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoDTO;
import com.hackacode.parque_diversiones.dto.EmpleadoJuegoResponseDTO;
import com.hackacode.parque_diversiones.exceptions.AsignacionDuplicadaError;
import com.hackacode.parque_diversiones.exceptions.JuegoNoEncontradoError;
import com.hackacode.parque_diversiones.model.Asignacion;
import com.hackacode.parque_diversiones.model.EmpleadoJuego;
import com.hackacode.parque_diversiones.model.Juego;
import com.hackacode.parque_diversiones.repository.EmpleadoJuegoRepository;
import com.hackacode.parque_diversiones.repository.JuegoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpleadoJuegoService implements IEmpleadoJuegoService{

    private final EmpleadoJuegoRepository empleadoJuegoRepository;
    private final JuegoRepository juegoRepository;

    public EmpleadoJuegoService(EmpleadoJuegoRepository empleadoJuegoRepository, JuegoRepository juegoRepository) {
        this.empleadoJuegoRepository = empleadoJuegoRepository;
        this.juegoRepository = juegoRepository;
    }

    @Override
    public EmpleadoJuegoResponseDTO guardarEmpleadoJuego(EmpleadoJuegoDTO empleadoDTO) {
        EmpleadoJuego aGuardar = new EmpleadoJuego();

        aGuardar.setNombre(empleadoDTO.getNombre());
        aGuardar.setApellido(empleadoDTO.getApellido());
        aGuardar.setDni(empleadoDTO.getDni());
        aGuardar.setAsignaciones(recuperarAsignaciones(empleadoDTO, aGuardar));
        EmpleadoJuego guardado = empleadoJuegoRepository.save(aGuardar);

        EmpleadoJuegoResponseDTO devuelto = new EmpleadoJuegoResponseDTO();
        devuelto.setId_empleado(guardado.getId_empleado());
        devuelto.setNombre(guardado.getNombre());
        devuelto.setApellido(guardado.getApellido());
        devuelto.setDni(guardado.getDni());
        devuelto.setAsignaciones(empleadoDTO.getAsignaciones()); // cambiar tal vez
        return devuelto;
    }

    @Override
    public EmpleadoJuego buscarEmpleado(Long id_empleado) {
        return empleadoJuegoRepository.findById(id_empleado).orElseThrow(
                () -> new NoSuchElementException("No se encontró al empleado con id " + id_empleado)
        );
    }

    /*
        verifica en las asignaciones que se pasan al crear el empleado, que existan los juegos que se están pasando,
        luego crea la asignacion asociada al juego y al empleado
     */
    private List<Asignacion> recuperarAsignaciones(EmpleadoJuegoDTO empleadoJuegoDTO, EmpleadoJuego empleadoJuego) {
        List<Asignacion> asignaciones = new ArrayList<>();
        validarAsignaciones(empleadoJuegoDTO);

        for (AsignacionDTO asignacionDTO : empleadoJuegoDTO.getAsignaciones()) {
            Juego juego = juegoRepository.findById(asignacionDTO.getId_juego())
                    .orElseThrow(() -> new JuegoNoEncontradoError("El juego con id " + asignacionDTO.getId_juego() + " no fue encontrado"));

            Asignacion asignacion = new Asignacion();
            asignacion.setJuego(juego);
            asignacion.setEmpleado(empleadoJuego);
            asignaciones.add(asignacion);
        }
        return asignaciones;
    }

    private void validarAsignaciones(EmpleadoJuegoDTO empleadoJuegoDTO) {
        Set<Long> idsJuegosValidados = empleadoJuegoDTO.getAsignaciones().stream()
                .map(AsignacionDTO::getId_juego)
                .collect(Collectors.toSet());

        if (idsJuegosValidados.size() != empleadoJuegoDTO.getAsignaciones().size()) {
            throw new AsignacionDuplicadaError("Se enviaron juegos duplicados en las asignaciones");
        }
    }
}
