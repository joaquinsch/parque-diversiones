package com.hackacode.parque_diversiones.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class EmpleadoAdministrativo extends Empleado{
}
