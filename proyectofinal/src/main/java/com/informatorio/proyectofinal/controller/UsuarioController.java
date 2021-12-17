package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import com.informatorio.proyectofinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "usuarios")
//@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?>crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.guardar(usuario), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/eliminar")
    public Usuario eliminarUsuario(@PathVariable("id") Long id, Usuario usuario) {
        return this.usuarioService.eliminar(id, usuario);
    }
    @PutMapping(value = "/{id}")
    public Usuario modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        return this.usuarioService.modificar(id, usuario);
    }
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(@RequestParam(name = "fecha", required = false)
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaDeCreacion,
                                                     @RequestParam(name = "ciudad", required = false) String ciudad) {
        return new ResponseEntity<>(usuarioService.obtenerTodos(fechaDeCreacion, ciudad), HttpStatus.OK);
    }
    /*
    //@Autowired
    UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // POST: Invoca al método crearUsuario
    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "usuario/{id}")
    public void eliminarUsuario(@PathVariable Long usuarioId, Usuario usuario) {
        usuarioService.eliminarUsuario(usuarioId, usuario);
    }

    @PutMapping("usuario/{id}")
    public Usuario modificarUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario){
        return this.usuarioService.modificarUsuario(usuarioId,usuario);
    }

    // creacionDespuesDeFecha(LocalDate fechaDesde)

    @GetMapping
    public ResponseEntity<?> obtenerTodos(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde) {
        if (fechaDesde != null) {
            List <Usuario> usuarios = usuarioRepository.creacionDespuesDeFecha(fechaDesde);
            return new ResponseEntity(usuarios, HttpStatus.OK);
        }
        return new ResponseEntity(usuarioRepository.findAll(), HttpStatus.OK);
    }

     */
}
