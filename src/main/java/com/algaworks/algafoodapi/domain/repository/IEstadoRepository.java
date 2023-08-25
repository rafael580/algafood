package com.algaworks.algafoodapi.domain.repository;


import com.algaworks.algafoodapi.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado,Long> {
}
