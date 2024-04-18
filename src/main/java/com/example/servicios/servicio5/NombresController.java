package com.example.servicios.servicio5;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/programacion-funcional")
public class NombresController {

    List<String> nombres = List.of("diego", "fernando","alessio", "luis", "carmelo","condorito");

    @GetMapping("/busqueda")
    public ResponseEntity<List<String>> buscarNombres(@RequestParam(required = false) String nombre){
        return ResponseEntity.ok(nombres.stream().filter(n->nombre==null || n.startsWith(nombre))
                .toList());
    }


}
