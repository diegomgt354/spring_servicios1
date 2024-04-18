package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.entity.Empleado;
import com.example.servicios.servicio6.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @PostMapping("/crearEmpleado")
    public ResponseEntity<Empleado> listarEmpleado(@RequestBody Empleado empleado){
        Empleado emp = empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(emp);
    }


}
