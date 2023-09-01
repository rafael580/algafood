package com.algaworks.algafoodapi.api.controller;


import com.algaworks.algafoodapi.domain.entity.Cozinha;
import com.algaworks.algafoodapi.api.service.CozinhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {


    @Autowired
    private CozinhaService cozinhaService;

    @GetMapping
    public ResponseEntity<List<Cozinha>> listar(){
        return  ResponseEntity.ok().body(cozinhaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> pegarUm(@PathVariable  Long id){
        return  ResponseEntity.status(HttpStatus.FOUND).body(cozinhaService.pegar(id));
    }

    @PostMapping
    public ResponseEntity<Cozinha> adicionar(@Valid @RequestBody Cozinha cozinha){
        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaService.criar(cozinha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable  Long id,@Valid @RequestBody Cozinha cozinha){

        return ResponseEntity.status(HttpStatus.OK).body(cozinhaService.atualizar(id,cozinha));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable  Long id){
            cozinhaService.delete(id);
            return ResponseEntity.noContent().build();

    }

}
