package com.example.servicios.servicio6.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

//    @JsonIgnore // que no tome en cuenta este  atributo
    @ManyToMany(mappedBy = "categorias")  // muchos a muchos
    @JsonBackReference // Categoria es el lado inverso - evita que se incluya la referencia a los productos asociados para prevenir la recursividad.
    private Set<Producto> productos; // tabla relacion
}
