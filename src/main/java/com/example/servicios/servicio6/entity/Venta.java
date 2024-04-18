package com.example.servicios.servicio6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ventas")
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // muchos a uno
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @OneToMany ( // uno a muchos
            mappedBy = "venta",
            // el detalle de la venta es manual despues de crear la venta
            // cuando se elimine venta, tambien se eliminara Detalle de venta
            cascade = {CascadeType.MERGE, CascadeType.REMOVE}
    )
    private Set<DetalleVenta> detalles;


}


