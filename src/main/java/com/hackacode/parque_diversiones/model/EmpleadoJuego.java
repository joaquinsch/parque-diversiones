package com.hackacode.parque_diversiones.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("JUEGO")
public class EmpleadoJuego extends Empleado {
}
