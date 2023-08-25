package com.algaworks.algafoodapi.domain.repository;


import com.algaworks.algafoodapi.domain.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormaPagamento  extends JpaRepository<FormaPagamento,Long> {
}
