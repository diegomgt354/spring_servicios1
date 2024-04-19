package com.example.servicios.servicio6.controller;

import com.example.servicios.servicio6.entity.Categoria;
import com.example.servicios.servicio6.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categorias")
@AllArgsConstructor
@Tag(
        name = "Api de categorias",
        description = "Esta api nos permite generar el registro de una categoria"
)
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping("/crearCategoria")
    @Operation(
            summary = "guardar categoria",
            description = "En el EndPoint se envia un objeto Categoria para poder ser guardado en la db",
            parameters = {
                    @Parameter(name = "categoria", description = "EL objeto  categoria a guardar")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 -> Registro Exitoso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 -> Solicitud incorrecta",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria nuevaCategoria = service.registerCategoria(categoria);
        return ResponseEntity.ok(nuevaCategoria);
    }
}
