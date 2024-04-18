package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.EmpleadoRepository;
import com.example.servicios.servicio6.entity.Empleado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }
}
