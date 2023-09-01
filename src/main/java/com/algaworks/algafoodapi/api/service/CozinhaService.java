package com.algaworks.algafoodapi.api.service;

import com.algaworks.algafoodapi.domain.entity.Cozinha;
import com.algaworks.algafoodapi.domain.repository.ICozinhaRepository;
import com.algaworks.algafoodapi.api.service.exception.DataBaseIntegrety;
import com.algaworks.algafoodapi.api.service.exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CozinhaService {



    @Autowired
    private ICozinhaRepository cozinhaRepository;

    @Transactional(readOnly = true)
    public List<Cozinha> listar(){
        return cozinhaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cozinha pegar(Long id) {
        return cozinhaRepository.findById(id).orElseThrow(()->  new EntidadeNaoEncontrada("cozinha nao encontrada"));
    }

    @Transactional
    public Cozinha criar(Cozinha cozinha){
      return   cozinhaRepository.save(cozinha);
    }

    @Transactional
    public Cozinha atualizar(Long id,Cozinha cozinha){
        var cz = cozinhaRepository.findById(id).orElseThrow(()->  new EntidadeNaoEncontrada("cozinha nao encontrada"));
        cz.setNome(cozinha.getNome());
        return cozinhaRepository.save(cz);
    }

    public void delete(Long id){
        try {
            cozinhaRepository.deleteById(id);

        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontrada("entidade nao existe"+id);
        }

        catch (DataIntegrityViolationException e){
            throw new DataBaseIntegrety("Integrety violation");
        }
    }

}
