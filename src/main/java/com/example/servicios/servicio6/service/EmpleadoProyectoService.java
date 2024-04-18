package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.EmpleadoProyectoRepository;
import com.example.servicios.servicio6.entity.EmpleadoProyecto;
import com.example.servicios.servicio6.entity.EmpleadoProyectoId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpleadoProyectoService {

    private final EmpleadoProyectoRepository empleadoProyectoRepository;

    public EmpleadoProyecto guardar(EmpleadoProyecto empleadoProyecto){
        return empleadoProyectoRepository.save(empleadoProyecto);
    }

    public EmpleadoProyecto buscarPorId(Long empleado_id, Long proyecto_id){
        EmpleadoProyectoId id = new EmpleadoProyectoId(empleado_id,proyecto_id);
        return empleadoProyectoRepository.findById(id).orElse(null);
    }

    public void eliminarPorId(Long empleado_id, Long proyecto_id){
        EmpleadoProyectoId id = new EmpleadoProyectoId(empleado_id,proyecto_id);
        empleadoProyectoRepository.deleteById(id);
    }
}
