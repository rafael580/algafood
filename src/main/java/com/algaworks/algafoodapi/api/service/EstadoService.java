package com.algaworks.algafoodapi.api.service;

import com.algaworks.algafoodapi.domain.entity.Estado;
import com.algaworks.algafoodapi.domain.repository.IEstadoRepository;
import com.algaworks.algafoodapi.api.service.exception.DataBaseIntegrety;
import com.algaworks.algafoodapi.api.service.exception.EntidadeNaoEncontrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {


    @Autowired
    private IEstadoRepository estadoRepository;

    @Transactional(readOnly = true)
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Estado pegar(Long id) {
        return estadoRepository.findById(id).orElseThrow(()->  new EntidadeNaoEncontrada("estado nao encontrado"));
    }

    @Transactional
    public Estado criar(Estado estado){
        return   estadoRepository.save(estado);
    }

    @Transactional
    public Estado atualizar(Long id,Estado estado){
        var cz = estadoRepository.findById(id).orElseThrow(()->  new EntidadeNaoEncontrada("estado nao encontrado"));
        cz.setNome(estado.getNome());
        return estadoRepository.save(cz);
    }


    public void delete(Long id){
        try {
            estadoRepository.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new DataBaseIntegrety("Id not found" + id);
        }
    }
}
