package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.entity.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICozinhaRepository extends JpaRepository<Cozinha,Long> {

    List<Cozinha> findByNome(String nome);


}
