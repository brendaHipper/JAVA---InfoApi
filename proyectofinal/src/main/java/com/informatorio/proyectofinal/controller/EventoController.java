package com.informatorio.proyectofinal.controller;

import com.informatorio.proyectofinal.entity.Evento;
import com.informatorio.proyectofinal.entity.Usuario;
import com.informatorio.proyectofinal.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "eventos")
public class EventoController {

    private final EventoService eventoService;
    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<>(eventoService.guardar(evento), HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}/eliminar")
    public Evento eliminarEvento(@PathVariable("id") Long id, Evento evento) {
        return this.eventoService.eliminar(id, evento);
    }
    @PutMapping(value = "/actualizar-estado")
    public void actualizarEvento() { this.eventoService.actualizar(); }

    @GetMapping(value = "/{id}/ranking")
    public ResponseEntity<?> rankingDelEvento(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoService.rankear(id), HttpStatus.OK);
    }
}
