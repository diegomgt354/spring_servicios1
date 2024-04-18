package com.example.servicios.servicio6.dao;

import com.example.servicios.servicio6.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
