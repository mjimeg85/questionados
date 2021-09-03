package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.services.CategoriaService;

@RestController
public class CategoriaController {
    
    @Autowired
    CategoriaService service;

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> traerCategorias() { //return Response Entity
        return ResponseEntity.ok(service.traerCategorias()); //return entity con el valor esperado
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Integer categoriaId) { 
        return ResponseEntity.ok(service.buscarCategoriaPorId(categoriaId)); 
    }


    
}
