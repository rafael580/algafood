package com.algaworks.algafoodapi.infrastructure.repository;

import com.algaworks.algafoodapi.domain.entity.Restaurante;
import com.algaworks.algafoodapi.domain.repository.IRestauranteRepository;
import com.algaworks.algafoodapi.domain.repository.IRestauranteRepositoryQueries;
import com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl  implements IRestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private IRestauranteRepository restauranteRepository;

    public List<Restaurante> consultar(String nome, BigDecimal taxaFreteInicial,BigDecimal taxaFreteFinal){


        CriteriaBuilder builder = null;
        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteria.from(Restaurante.class);

        var predicates = new ArrayList<Predicate>();
        if(StringUtils.hasText(nome)){
           predicates.add( builder.like(root.get("nome"), "%" + nome + "%"));
        }
        if(taxaFreteInicial != null){
            predicates.add( builder.like(root.get("taxaFrete"), "%" + taxaFreteInicial + "%"));
        }
        if(taxaFreteInicial != null){
            predicates.add( builder.like(root.get("taxaFrete"), "%" + taxaFreteFinal + "%"));
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Restaurante> query = manager.createQuery(criteria);
        return query.getResultList();

    }

    @Override
    public List<Restaurante> findComFreteGratis(String nome) {
        return restauranteRepository.findAll(RestauranteSpecs.comFreteGratis().and(RestauranteSpecs.comNomeSemelhante(nome)));
    }

}
