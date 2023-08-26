package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface IRestauranteRepository  extends JpaRepository<Restaurante,Long> , JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> queryByTaxaFreteBetween (BigDecimal taxaInicial, Long Cozinha);

   // @Query(value = "SELECT * FROM tb_managers m where (m.cpf = :cpf OR m.email= :email OR m.registration = :registration)", nativeQuery = true)
   // Manager findManagerByCpfOrByEmailOrByRegistration(@Param(value = "cpf") String cpf,
   // @Param(value = "email") String email, @Param(value = "registration") String registration);
   //@Query("from Restaurante where nome loke %:nome% and cozinha.id = :id")
   // List<Restaurante> consultarPorNome(String nome,@Param("id") Long Cozinha);
    List<Restaurante> findByNomeContainingAndCozinhaId(String nome,Long Cozinha);

    Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    int countByCozinhaId(Long Cozinha);
}
