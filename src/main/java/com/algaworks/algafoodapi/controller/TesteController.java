package com.algaworks.algafoodapi.controller;

import com.algaworks.algafoodapi.domain.entity.Restaurante;
import com.algaworks.algafoodapi.domain.repository.IRestauranteRepository;
import com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {


    @Autowired
    private IRestauranteRepository restauranteRepository;

    @GetMapping
    public List<Restaurante> pegar(String nome){

        return restauranteRepository.findAll(RestauranteSpecs.comFreteGratis().and(RestauranteSpecs.comNomeSemelhante(nome)));
    }

}
