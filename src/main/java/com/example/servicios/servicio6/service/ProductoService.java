package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.CategoriaRepository;
import com.example.servicios.servicio6.dao.ProductoRepository;
import com.example.servicios.servicio6.entity.Categoria;
import com.example.servicios.servicio6.entity.Producto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductoService {

    private final CategoriaRepository repositoryCategoria;
    private final ProductoRepository repositoryProducto;

    @Transactional
    public Producto agregarProductoConCategorias(Producto producto, Set<Long> categoriasIds){
        List<Categoria> lista_categorias = repositoryCategoria.findAllById(categoriasIds);
        Set<Categoria> categorias = new HashSet<>(lista_categorias);
        producto.setCategorias(categorias);
        return repositoryProducto.save(producto);
    }
}
