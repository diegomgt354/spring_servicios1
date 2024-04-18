package com.example.servicios.servicio4.controller;

import com.example.servicios.servicio4.entity.UsuariosEntity;
import com.example.servicios.servicio4.service.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@AllArgsConstructor
public class UsuariosController {

    private final UsuariosService usuariosService;

//    @Qualifier("UsuariosServiceImpl")
//    @Autowired
//    private UsuariosService usuariosService;

    @GetMapping
    public List<UsuariosEntity> list(){
        return usuariosService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosEntity> searchForId(@PathVariable Long id){
        UsuariosEntity search = usuariosService.userForId(id);
        return (search!=null)?ResponseEntity.ok(search)
                :ResponseEntity.notFound().build();
    }

    @GetMapping("/searchForName/{nombres}")
    public List<UsuariosEntity> searchForName(@PathVariable String nombres){
        return usuariosService.findAllByNombres(nombres);
    }

    @PostMapping
    public ResponseEntity<UsuariosEntity> add(@RequestBody UsuariosEntity entity){
        UsuariosEntity usuariosEntity = usuariosService.add(entity);
        return ResponseEntity.ok(usuariosEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosEntity> update(@RequestBody UsuariosEntity entity, @PathVariable Long id){
        UsuariosEntity update = usuariosService.update(entity,id);
        return (update!=null)?ResponseEntity.ok(update)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete_logico/{id}")
    public ResponseEntity<UsuariosEntity> deleteLogico(@PathVariable Long id){
        UsuariosEntity usuario = usuariosService.deleteLogico(id);
        return (usuario!=null)?ResponseEntity.noContent().build()
                :ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuariosEntity> delete(@PathVariable Long id){
        boolean validate = usuariosService.delete(id);
        return (validate)?ResponseEntity.noContent().build()
                :ResponseEntity.notFound().build();
    }
}
