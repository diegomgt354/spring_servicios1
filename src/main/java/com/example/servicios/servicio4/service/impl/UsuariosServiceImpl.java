package com.example.servicios.servicio4.service.impl;

import com.example.servicios.servicio4.entity.UsuariosEntity;
import com.example.servicios.servicio4.repository.UsuariosRepository;
import com.example.servicios.servicio4.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    public UsuariosRepository repository;

    @Override
    public List<UsuariosEntity> list() {
        return repository.findAll();
    }

    @Override
    public UsuariosEntity userForId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UsuariosEntity add(UsuariosEntity usuario) {
        return repository.save(usuario);
    }

//    @Override
//    public UsuariosEntity update(UsuariosEntity usuario, Long id) {
//        boolean entity_update = repository.existsById(id);
//        if(entity_update){
//            usuario.setId(id);
//            return repository.save(usuario);
//        }
//        return null;
//    }

    @Override
    public UsuariosEntity update(UsuariosEntity usuario, Long id) {
        Optional<UsuariosEntity> before_entity = repository.findById(id);
        if(before_entity.isPresent()){
            usuario.setId(id);
            if(usuario.getNombres()==null){
                usuario.setNombres(before_entity.get().getNombres());
            }
            if(usuario.getApellidos()==null){
                usuario.setApellidos(before_entity.get().getApellidos());
            }
            if(usuario.getEstado()==null){
                usuario.setEstado(before_entity.get().getEstado());
            }
            return repository.save(usuario);
        }
        return null;
    }


    @Override
    public boolean delete(Long id) {
        boolean entity_update = repository.existsById(id);
        if(entity_update){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UsuariosEntity deleteLogico(Long id) {
        Optional<UsuariosEntity> usuario = repository.findById(id);
        if(usuario.isPresent()){
            usuario.get().setEstado(0);
            return repository.save(usuario.get());
        }
        return null;
    }

    @Override
    public List<UsuariosEntity> findAllByNombres(String nombres) {
        return repository.findAllByNombres(nombres);
    }
}
