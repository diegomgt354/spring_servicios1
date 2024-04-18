package com.example.servicios.servicio4.service;

import com.example.servicios.servicio4.entity.UsuariosEntity;
import com.example.servicios.servicio4.repository.UsuariosRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuariosService {

    List<UsuariosEntity> list();
    UsuariosEntity userForId(Long id);
    UsuariosEntity add(UsuariosEntity usuario);
    UsuariosEntity update(UsuariosEntity usuario, Long id);
    boolean delete(Long id);
    UsuariosEntity deleteLogico(Long id);
    List<UsuariosEntity> findAllByNombres(String nombres);

}
