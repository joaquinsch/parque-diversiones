package com.hackacode.parque_diversiones.repository;

import com.hackacode.parque_diversiones.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {
}
