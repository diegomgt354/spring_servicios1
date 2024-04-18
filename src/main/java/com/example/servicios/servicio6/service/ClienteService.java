package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.ClienteRepository;
import com.example.servicios.servicio6.entity.Cliente;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional // si hay error borra lo ejecutado y no hace nada
    public Cliente registerCliente(Cliente entidad){
        return repository.save(entidad);
    }

}
