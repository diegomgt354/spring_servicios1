package com.example.servicios.servicio6.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class VentaRequest {

    private Long clienteId;
    private Set<DetalleRequest> detalles;
}
