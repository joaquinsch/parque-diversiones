package com.hackacode.parque_diversiones.repository;

import com.hackacode.parque_diversiones.model.EmpleadoJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoJuegoRepository extends JpaRepository<EmpleadoJuego, Long> {
}
