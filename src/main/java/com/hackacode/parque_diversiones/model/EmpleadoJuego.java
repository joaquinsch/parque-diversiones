package com.hackacode.parque_diversiones.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("JUEGO")
@Getter
@Setter
@NoArgsConstructor
public class EmpleadoJuego extends Empleado {
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asignacion> asignaciones;
}
