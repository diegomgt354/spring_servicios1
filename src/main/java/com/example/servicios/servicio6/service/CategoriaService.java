package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.CategoriaRepository;
import com.example.servicios.servicio6.entity.Categoria;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Transactional // si hay error borra lo ejecutado y no hace nada / rollback
    public Categoria registerCategoria(Categoria entidad){
        return categoriaRepository.save(entidad);
    }

    @Transactional
    public Categoria updateCategoria(Categoria entidad, Long id){
        Categoria categoriaUpdate = categoriaRepository.findById(id).orElse(null);
        if(categoriaUpdate==null){
            return null;
        }
        categoriaUpdate.setId(id);
        return categoriaRepository.save(entidad);

    }

}
