package com.algaworks.algafoodapi.infrastructure.repository.spec;

import com.algaworks.algafoodapi.domain.entity.Restaurante;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
@AllArgsConstructor
public class RestauranteComNomeSemelhanteSpec  implements Specification<Restaurante> {

    private static final long serialVersionUID = 1L;

    private String nome;

    @Override
    public Predicate toPredicate(
            Root<Restaurante> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {


        return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
}
