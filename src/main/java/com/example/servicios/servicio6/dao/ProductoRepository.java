package com.example.servicios.servicio6.dao;

import com.example.servicios.servicio6.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
