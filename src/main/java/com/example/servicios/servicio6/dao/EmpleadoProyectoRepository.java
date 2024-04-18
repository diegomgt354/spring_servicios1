package com.example.servicios.servicio6.dao;

import com.example.servicios.servicio6.entity.EmpleadoProyecto;
import com.example.servicios.servicio6.entity.EmpleadoProyectoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoProyectoRepository extends JpaRepository<EmpleadoProyecto, EmpleadoProyectoId> {
}
