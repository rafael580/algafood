package com.algaworks.algafoodapi.domain.entity;



import com.algaworks.algafoodapi.core.validation.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha  implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull(groups = Groups.CadastroRestaurante.class )
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "cozinha")
    private List<Restaurante> restaurantes = new ArrayList<>();

    public Cozinha(){}

    public Cozinha(String nome) {
        this.nome = nome;
    }

}
