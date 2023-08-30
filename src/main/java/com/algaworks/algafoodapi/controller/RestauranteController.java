package com.algaworks.algafoodapi.controller;

import com.algaworks.algafoodapi.Groups;
import com.algaworks.algafoodapi.domain.entity.Restaurante;
import com.algaworks.algafoodapi.domain.repository.IRestauranteRepository;
import com.algaworks.algafoodapi.service.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    IRestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteService restauranteService;


    @GetMapping
    public ResponseEntity<List<Restaurante>> listar(){
        return  ResponseEntity.ok().body(restauranteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> pegarUm(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.FOUND).body(restauranteService.pegar(id));
    }


    @PostMapping
    public ResponseEntity<Restaurante> adicionar(@Valid @RequestBody   Restaurante restaurante){
            return  ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.adicionar(restaurante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id,@RequestBody  Restaurante restaurante){
        return  ResponseEntity.status(HttpStatus.OK).body(restauranteService.atualizar(id,restaurante));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarParcial(@PathVariable Long id,@Valid @RequestBody Map<String,Object> campos){

        var restauranteAtual = restauranteService.pegar(id);

        merge(campos,restauranteAtual);

        return atualizar(id,restauranteAtual);
    }


    private void merge(Map<String,Object> camposOrigem,Restaurante restauranteDestino){

        ObjectMapper objectMapper = new ObjectMapper();
        var restauranteOrigem = objectMapper.convertValue(camposOrigem,Restaurante.class);

        camposOrigem.forEach((nomeP,valorP)->{
        Field field = ReflectionUtils.findField(Restaurante.class,nomeP);
        field.setAccessible(true);
        Object novoValor = ReflectionUtils.getField(field,restauranteOrigem);
        ReflectionUtils.setField(field,restauranteDestino,novoValor);
        });
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        restauranteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
