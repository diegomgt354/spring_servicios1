package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.ProyectoRepository;
import com.example.servicios.servicio6.entity.Proyecto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public Proyecto guardarProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }
}
