package com.algaworks.algafoodapi.domain.entity;



import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="tab_cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha  implements Serializable {

    private static final long serialVersionUID = 1L;


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_cozinha",length = 30)
    private String nome;


    public Cozinha(){}

    public Cozinha(String nome) {
        this.nome = nome;
    }

}
