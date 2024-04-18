package com.example.servicios.servicio6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable // indica que esta clase es incrustable - forma parte de otra entidad
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoProyectoId implements Serializable { // para persisitir datos y comunicaccion entre aplicaciones

    @Column(name = "empleado_id")
    private Long empleadoId;

    @Column(name = "proyecto_id")
    private Long proyectoId;



}
