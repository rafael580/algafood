create table forma_pagamento (
id bigint not null auto_increment,
 descricao varchar(255),
 primary key (id)) engine=InnoDB;

create table grupo (
id bigint not null auto_increment,
 nome varchar(255),
  primary key (id)) engine=InnoDB;

create table grupo_permissoes (
grupo_id bigint not null,
 permissaoes_id bigint not null) engine=InnoDB;

create table permissao (
id bigint not null auto_increment,
 descricao varchar(255),
 nome varchar(255), primary key (id)) engine=InnoDB;

create table produto (
ativo bit,
preco decimal(38,2),
 id bigint not null auto_increment,
  restaurante_id bigint,
  descricao varchar(255),
  nome varchar(255),
  primary key (id)) engine=InnoDB;

create table restaurante (
aberto bit,
ativo bit,
 taxa_frete decimal(38,2),
  cozinha_id bigint,
  data_atualizacao datetime not null,
   data_cadastro datetime not null,
    endereco_cidade_id bigint,
     id bigint not null auto_increment,
      endereco_bairro varchar(255),
      endereco_cep varchar(255),
       endereco_complemento varchar(255),
        endereco_logradouro varchar(255),
         endereco_numero varchar(255),
         nome varchar(255), primary key (id)) engine=InnoDB;

create table `restaurante_forma_pagamento` (
forma_pagamento_id bigint not null,
restaurante_id bigint not null) engine=InnoDB;

create table restaurante_produtos (
produtos_id bigint not null,
 restaurante_id bigint not null) engine=InnoDB;

create table usuario (
data_cadastro datetime(6),
id bigint not null auto_increment,
 nome varchar(255), senha varchar(255),
  primary key (id)) engine=InnoDB;

create table usuario_grupos (
grupos_id bigint not null,
 usuario_id bigint not null) engine=InnoDB;

