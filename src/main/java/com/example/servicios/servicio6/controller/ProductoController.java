package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.entity.Producto;
import com.example.servicios.servicio6.request.ProductoRequest;
import com.example.servicios.servicio6.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productos")
@AllArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @PostMapping("/crearProducto")
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoRequest request){
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(request.getNombre());
        nuevoProducto.setPrecio(request.getPrecio());
        Producto productoGuardado = service.agregarProductoConCategorias(nuevoProducto, request.getCategoriasIds());
        return ResponseEntity.ok(productoGuardado);
    }

}
