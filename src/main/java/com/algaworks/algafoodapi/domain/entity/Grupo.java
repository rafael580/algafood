package com.algaworks.algafoodapi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_grupo")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;

    @ManyToMany
    private List<Permissao> permissaoes = new ArrayList<>();

    public Grupo(){}

}
