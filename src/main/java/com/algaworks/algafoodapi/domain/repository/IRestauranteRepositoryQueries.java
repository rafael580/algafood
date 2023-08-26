package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.entity.Restaurante;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IRestauranteRepositoryQueries {

    List<Restaurante> consultar(String nome, BigDecimal taxaFreteInicial,BigDecimal taxaFreteFinal);

    List<Restaurante> findComFreteGratis(String nome);

}
