package com.example.servicios.servicio6.dao;

import com.example.servicios.servicio6.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

//    Optional<List<Categoria>> findIdNot(Long id);

}
