package com.algaworks.algafoodapi.domain.repository;


import com.algaworks.algafoodapi.domain.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestauranteRepository  extends JpaRepository<Restaurante,Long> {
}
