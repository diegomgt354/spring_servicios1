package com.example.servicios.servicio6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_venta")
@Getter
@Setter
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) // no se carga hasta completar todos los detalles
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

}
