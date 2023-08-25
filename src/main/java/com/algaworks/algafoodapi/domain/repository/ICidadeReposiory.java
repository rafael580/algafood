package com.algaworks.algafoodapi.domain.repository;


import com.algaworks.algafoodapi.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICidadeReposiory  extends JpaRepository<Cidade,Long> {
}
