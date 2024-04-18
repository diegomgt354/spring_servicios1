package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.entity.EmpleadoProyecto;
import com.example.servicios.servicio6.service.EmpleadoProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empleadoProyecto")
@AllArgsConstructor
public class EmpleadoProyectoController {

    private final EmpleadoProyectoService empleadoProyectoService;

    @PostMapping("/crearEmpleadoProyecto")
    public ResponseEntity<EmpleadoProyecto> agregarEmpleadoProyecto(@RequestBody EmpleadoProyecto empleadoProyecto){
        EmpleadoProyecto emp_pro = empleadoProyectoService.guardar(empleadoProyecto);
        return ResponseEntity.ok(emp_pro);
    }

    @GetMapping("/buscarEmpleadoProyecto/{empleadoId}/{proyectoId}")
    public ResponseEntity<EmpleadoProyecto> buscarEmpleadoProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId){
        EmpleadoProyecto emp_pro = empleadoProyectoService.buscarPorId(empleadoId, proyectoId);
        return (emp_pro==null)?ResponseEntity.notFound().build():ResponseEntity.ok(emp_pro);
    }

    @DeleteMapping("/eliminarEmpleadoProyecto/{empleadoId}/{proyectoId}")
    public ResponseEntity<Void> eliminarEmpleadoProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId){
        empleadoProyectoService.eliminarPorId(empleadoId, proyectoId);
        return ResponseEntity.ok().build();
    }

}
