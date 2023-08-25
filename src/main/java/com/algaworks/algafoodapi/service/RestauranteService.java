package com.algaworks.algafoodapi.service;

import com.algaworks.algafoodapi.domain.entity.Restaurante;
import com.algaworks.algafoodapi.domain.repository.IRestauranteRepository;
import com.algaworks.algafoodapi.service.exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestauranteService {


    @Autowired
    private IRestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaService cozinhaService;

    @Transactional(readOnly = true)
    public List<Restaurante> listar(){
        return restauranteRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Restaurante pegar(Long id){
        return restauranteRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontrada("restaurante nao encontrado"));
    }
    @Transactional
    public Restaurante adicionar(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }
    @Transactional
    public Restaurante atualizar(Long id,Restaurante restaurante){
        var rs = restauranteRepository.findById(id).orElse(null);

        rs.setNome(restaurante.getNome());
        rs.setCozinha(cozinhaService.pegar(restaurante.getCozinha().getId()));
        return restauranteRepository.save(rs);
    }




}
