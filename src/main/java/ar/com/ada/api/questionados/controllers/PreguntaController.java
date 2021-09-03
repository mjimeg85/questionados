package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Pregunta;
import ar.com.ada.api.questionados.services.PreguntaService;

@RestController
public class PreguntaController {

    @Autowired
    PreguntaService service;

    @GetMapping("/pregunta")
    public ResponseEntity<List<Pregunta>> traerPreguntas() { //return Response Entity
        return ResponseEntity.ok(service.traerPreguntas()); //return entity con el valor esperado
    }
    
    @GetMapping("/pregunta/{id}")
    public ResponseEntity<Pregunta> buscarPreguntaPorId(@PathVariable Integer preguntaId) { 
        return ResponseEntity.ok(service.buscarPreguntaPorId(preguntaId)); 
    }
}
