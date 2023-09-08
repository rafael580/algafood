package com.algaworks.algafoodapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupo")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo  implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    @ManyToMany
    private List<Permissao> permissoes = new ArrayList<>();

    public Grupo(){}

}
