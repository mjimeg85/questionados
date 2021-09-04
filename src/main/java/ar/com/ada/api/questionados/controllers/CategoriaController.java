package ar.com.ada.api.questionados.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.questionados.entities.Categoria;
import ar.com.ada.api.questionados.models.response.GenericResponse;
import ar.com.ada.api.questionados.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias() { // return Response Entity
        return ResponseEntity.ok(service.traerCategorias()); // return entity con el valor esperado
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Integer categoriaId) {
        return ResponseEntity.ok(service.buscarCategoriaPorId(categoriaId));
    }

    @PostMapping("/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {

        GenericResponse r = new GenericResponse();

        if (service.crearCategoria(categoria)) {
            r.id = categoria.getCategoriaId();
            r.isOk = true;
            r.message = "Categoria creada con exito";
            return ResponseEntity.ok(r);
        } else {
            r.isOk = false;
            r.message = "Esta categoria ya esta creada";
            return ResponseEntity.badRequest().body(r);
        }

    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> eliminarCategoriaPorId(@PathVariable Integer id) {
        service.eliminarCategoriaPorId(id);

        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.message = "Categoria dada de baja con exito";

        return ResponseEntity.ok(respuesta);
    }

}
