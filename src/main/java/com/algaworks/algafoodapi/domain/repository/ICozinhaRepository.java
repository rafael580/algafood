package com.algaworks.algafoodapi.domain.repository;


import com.algaworks.algafoodapi.domain.entity.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICozinhaRepository extends JpaRepository<Cozinha,Long> {
}
