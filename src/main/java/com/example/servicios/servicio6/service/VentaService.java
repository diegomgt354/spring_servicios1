package com.example.servicios.servicio6.service;

import com.example.servicios.servicio6.dao.ClienteRepository;
import com.example.servicios.servicio6.dao.DetalleVentaRepository;
import com.example.servicios.servicio6.dao.VentaRepository;
import com.example.servicios.servicio6.entity.Cliente;
import com.example.servicios.servicio6.entity.DetalleVenta;
import com.example.servicios.servicio6.entity.Venta;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public Venta registrarVenta(Venta venta, Set<DetalleVenta> detalles){
        Cliente cliente = clienteRepository.findById(venta.getCliente().getId()).orElse(null);
        venta.setCliente(cliente);
        venta = ventaRepository.save(venta);

        for(DetalleVenta detalle : detalles){
            detalle.setVenta(venta);
            detalleVentaRepository.save(detalle);
        }

        venta.setDetalles(detalles);
        return venta;
    }
}
