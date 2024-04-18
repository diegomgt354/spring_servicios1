package com.example.servicios.servicio4.repository;

import com.example.servicios.servicio4.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity,Long> {

    List<UsuariosEntity> findAllByNombres(String nombres);

}
