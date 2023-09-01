package com.algaworks.algafoodapi.api.service;

import com.algaworks.algafoodapi.domain.entity.FormaPagamento;
import com.algaworks.algafoodapi.domain.entity.Restaurante;
import com.algaworks.algafoodapi.domain.repository.IFormaPagamento;
import com.algaworks.algafoodapi.domain.repository.IRestauranteRepository;
import com.algaworks.algafoodapi.api.service.exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestauranteService {


    @Autowired
    private IRestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaService cozinhaService;

    @Autowired
    private IFormaPagamento iFormaPagamento;

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
        var rs = restauranteRepository.getOne(id);
        copy(rs,restaurante);
        return restauranteRepository.save(rs);
    }

    private void copy(Restaurante inicial, Restaurante destino){

        List<FormaPagamento> formaPagamentos = new ArrayList<>();

        inicial.setNome(destino.getNome());
        inicial.setAberto(destino.getAberto());
        inicial.setAtivo(destino.getAtivo());
        inicial.setDataAtualizacao(destino.getDataAtualizacao());
        inicial.setDataCadastro(destino.getDataCadastro());
        inicial.setCozinha(cozinhaService.pegar(destino.getCozinha().getId()));
        inicial.setTaxaFrete(destino.getTaxaFrete());
        inicial.getFormaPagamentos().clear();


        destino.getFormaPagamentos().forEach(x->{
          FormaPagamento formaPagamento = iFormaPagamento.getOne(x.getId());
            inicial.getFormaPagamentos().add(formaPagamento);
        });
    }
}
