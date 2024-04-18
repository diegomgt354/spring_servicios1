package com.example.servicios.servicio6.dao;

import com.example.servicios.servicio6.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
