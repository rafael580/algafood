package com.algaworks.algafoodapi.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "tab_restaurante")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private Boolean ativo;
    private Boolean aberto;
    private Date dataCadastro;
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    @ManyToOne
    private FormaPagamento formaPagamento;

    public Restaurante(){}

    public Restaurante(Long id,
                       String nome,
                       BigDecimal taxaFrete,
                       Boolean ativo,
                       Boolean aberto,
                       Date dataCadastro,
                       Date dataAtualizacao,
                       Cozinha cozinha,
                       FormaPagamento formaPagamento) {
        this.id = id;
        this.nome = nome;
        this.taxaFrete = taxaFrete;
        this.ativo = ativo;
        this.aberto = aberto;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.cozinha = cozinha;
        this.formaPagamento = formaPagamento;
    }
}
