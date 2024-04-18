package com.example.servicios.servicio6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado_proyecto")
@Getter
@Setter
public class EmpleadoProyecto {

    @EmbeddedId // define la clave compuesta - contiene los campos de las llaves primarias
    private EmpleadoProyectoId id;

    @Column(name = "rol")
    private String rol;
}
