package com.lunatics.encuesta.controllers;

import com.lunatics.encuesta.models.Encuesta;
import com.lunatics.encuesta.repositories.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestaRepository encuestaRepository;

    @GetMapping
    public ResponseEntity<Iterable<Encuesta>> listarTodasLasEncuestas() {
        return new ResponseEntity<>(encuestaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> crearEncuesta(@RequestBody Encuesta encuesta) {
        encuesta = encuestaRepository.save(encuesta);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newEncuestaUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encuesta.getId()).toUri();
        httpHeaders.setLocation(newEncuestaUri);

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEncuestaPorId(@PathVariable Long id) {

        Optional<Encuesta> encuesta = encuestaRepository.findById(id);

        if (encuesta.isPresent()) {
            return new ResponseEntity<>(encuesta, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    //Editar una Encuesta
    @PutMapping("/{id}")
    public ResponseEntity<Encuesta> editarEncuesta(@RequestBody Encuesta encuesta, @PathVariable Long id) {
        encuesta.setId(id);
        Encuesta encuestaBD = encuestaRepository.save(encuesta);
        return new ResponseEntity<>(encuestaBD, HttpStatus.OK);
    }


    //Eliminar una Encuesta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEncuesta(@PathVariable Long id) {
        try {
           encuestaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }


}
