package com.algaworks.algafoodapi.controller;

import com.algaworks.algafoodapi.domain.entity.Cozinha;
import com.algaworks.algafoodapi.domain.entity.Estado;
import com.algaworks.algafoodapi.service.CozinhaService;
import com.algaworks.algafoodapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> listar(){
        return  ResponseEntity.ok().body(estadoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> pegarUm(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.FOUND).body(estadoService.pegar(id));
    }

    @PostMapping
    public ResponseEntity<Estado> adicionar(@RequestBody Estado estado){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.criar(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> atualizar(@PathVariable  Long id,@RequestBody Estado estado){

        return ResponseEntity.status(HttpStatus.OK).body(estadoService.atualizar(id,estado));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable  Long id){
        estadoService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
