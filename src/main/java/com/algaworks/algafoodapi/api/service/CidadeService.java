package com.algaworks.algafoodapi.api.service;

import com.algaworks.algafoodapi.domain.entity.Cidade;
import com.algaworks.algafoodapi.domain.repository.ICidadeReposiory;
import com.algaworks.algafoodapi.api.service.exception.DataBaseIntegrety;
import com.algaworks.algafoodapi.api.service.exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {



    @Autowired
    private ICidadeReposiory cidadeRepository;

    @Autowired
    private  EstadoService estadoService;

    @Transactional(readOnly = true)
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cidade pegar(Long id) {
        return cidadeRepository.findById(id).orElseThrow(()->  new EntidadeNaoEncontrada("cidade nao encontrada"));
    }

    @Transactional
    public Cidade criar(Cidade estado){
        return   cidadeRepository.save(estado);
    }

    @Transactional
    public Cidade atualizar(Long id,Cidade cidade){
        var cz = cidadeRepository.findById(id).orElseThrow(()->  new EntidadeNaoEncontrada("cidade nao encontrada"));
        cz.setNome(cidade.getNome());
        cz.setEstado(estadoService.pegar(cidade.getEstado().getId()));
        return cidadeRepository.save(cz);
    }


    public void delete(Long id){
        try {
            cidadeRepository.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new DataBaseIntegrety("Id not found" + id);
        }
    }

}
