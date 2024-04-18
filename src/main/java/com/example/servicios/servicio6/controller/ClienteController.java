package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.entity.Cliente;
import com.example.servicios.servicio6.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente nuevo_cliente = clienteService.registerCliente(cliente);
        return ResponseEntity.ok(nuevo_cliente);
    }


}
