package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.entity.Empleado;
import com.example.servicios.servicio6.entity.Proyecto;
import com.example.servicios.servicio6.service.EmpleadoService;
import com.example.servicios.servicio6.service.ProductoService;
import com.example.servicios.servicio6.service.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/proyectos")
@AllArgsConstructor
public class ProyectoController {

    private final ProyectoService proyectoService;

    @PostMapping("/crearProyecto")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto){
        Proyecto pro = proyectoService.guardarProyecto(proyecto);
        return ResponseEntity.ok(pro);
    }

}
