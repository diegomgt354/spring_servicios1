package com.example.servicios.servicio6.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "productos")
@Getter
@Setter
// evita que la respuesta sea un bucle infinito
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    // configuracion que se aplica a la entidad con mas poder
    @ManyToMany // muchos a muchos
    @JoinTable( // permite tener varios parametros de configuracion / para la tabla
            name = "producto_categoria", // nombre a 3era entidad/tabla
            joinColumns = @JoinColumn(name = "producto_id"), // atributo a unir de esta entidad
            inverseJoinColumns = @JoinColumn(name = "categoria_id") // atributo a unir de la entidad relacionda
    )
    @JsonManagedReference // Producto posee la relación - indica que se serializará completamente, incluyendo la referencia a las categorías asociadas
    private Set<Categoria> categorias; // tabla relacion

}
