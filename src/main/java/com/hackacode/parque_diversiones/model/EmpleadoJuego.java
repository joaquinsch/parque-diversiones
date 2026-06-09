package com.hackacode.parque_diversiones.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("JUEGO")
@Getter @Setter
@NoArgsConstructor
public class EmpleadoJuego extends Empleado {

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;
}
