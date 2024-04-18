package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.dao.ClienteRepository;
import com.example.servicios.servicio6.dao.ProductoRepository;
import com.example.servicios.servicio6.entity.Cliente;
import com.example.servicios.servicio6.entity.DetalleVenta;
import com.example.servicios.servicio6.entity.Producto;
import com.example.servicios.servicio6.entity.Venta;
import com.example.servicios.servicio6.request.DetalleRequest;
import com.example.servicios.servicio6.request.VentaRequest;
import com.example.servicios.servicio6.service.ClienteService;
import com.example.servicios.servicio6.service.ProductoService;
import com.example.servicios.servicio6.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/ventas")
@AllArgsConstructor
public class VentaController {

    private final VentaService ventaService;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    @PostMapping("/crearVenta")
    public ResponseEntity<Venta> crearVenta(@RequestBody VentaRequest ventaRequest){
        Cliente cliente = clienteRepository.findById(ventaRequest.getClienteId())
                .orElseThrow(()->new RuntimeException("Cliente no encontrado"));

        Venta nuevaVenta = new Venta();
        nuevaVenta.setCliente(cliente);


        Set<DetalleVenta> detalles = new HashSet<>();
        for(DetalleRequest detalleDto : ventaRequest.getDetalles()){

            Producto producto = productoRepository.findById(detalleDto.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad(detalleDto.getCantidad());
            detalles.add(detalleVenta);

        }

        nuevaVenta.setDetalles(detalles);
        Venta ventaGuardada = ventaService.registrarVenta(nuevaVenta,detalles);
        return ResponseEntity.ok(ventaGuardada);
    }


}
