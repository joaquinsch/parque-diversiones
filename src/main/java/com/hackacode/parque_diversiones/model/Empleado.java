package com.hackacode.parque_diversiones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;
    private String nombre;
    private String apellido;
    private String dni;
    @OneToMany(mappedBy = "empleado")
    private List<Asignacion> asignaciones;
}
