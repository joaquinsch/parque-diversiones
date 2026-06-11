package com.hackacode.parque_diversiones.repository;


import com.hackacode.parque_diversiones.model.EmpleadoJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoJuegoRepository extends JpaRepository<EmpleadoJuego, Long> {

    @Query(value = "SELECT a.id_juego FROM asignacion a INNER JOIN empleado e ON e.id_empleado = a.id_empleado WHERE e.id_empleado = :id_empleado",
            nativeQuery = true)
    List<Long> obtenerJuegosDelEmpleado(Long id_empleado);

}
