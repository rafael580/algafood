package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.entity.Cidade;
import com.algaworks.algafoodapi.api.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;


    @GetMapping
    public ResponseEntity<List<Cidade>> listar(){
        return  ResponseEntity.ok().body(cidadeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> pegarUm(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.FOUND).body(cidadeService.pegar(id));
    }

    @PostMapping
    public ResponseEntity<Cidade> adicionar(@RequestBody Cidade cidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.criar(cidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable  Long id,@RequestBody Cidade cidade){

        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.atualizar(id,cidade));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable  Long id){
        cidadeService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
