package com.algaworks.algafoodapi.domain.entity;

import com.algaworks.algafoodapi.core.validation.Groups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "restaurante")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank// valid
    private String nome;
    @PositiveOrZero //valid
    private BigDecimal taxaFrete;
    private Boolean ativo;
    private Boolean aberto;


    @CreationTimestamp
    @Column(nullable = false,columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false,columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;


    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)
    private Cozinha cozinha;

    @JsonIgnore
    @Valid
    @ConvertGroup(from = Default.class, to = Groups.CadastroRestaurante.class)
    @NotNull
    @ManyToMany //(fetch = FetchType.EAGER)
    @JoinTable(name = "restaurante_forma_pagamento" ,
            joinColumns = @JoinColumn(name = "restaurante_id"),
            inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formaPagamentos = new ArrayList<>();

    @JsonIgnore
    @Embedded
    private Endereco endereco;
    @JsonIgnore
    @OneToMany
    List<Produto> produtos = new ArrayList<>();


    public Restaurante(){}

    public Restaurante(Long id,
                       String nome,
                       BigDecimal taxaFrete,
                       Boolean ativo,
                       Boolean aberto,
                       LocalDateTime dataCadastro,
                       LocalDateTime dataAtualizacao,
                       Cozinha cozinha) {
        this.id = id;
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.cozinha = cozinha;
    }
}
