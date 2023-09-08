set foreign_key_checks = 0;

lock tables cidade write, cozinha write, estado write, forma_pagamento write,
	grupo write, grupo_permissoes write, permissao write,
	produto write, restaurante write, restaurante_forma_pagamento write,
	usuario write, usuario_grupos write,
	pedido write, item_pedido write;


delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupos;
delete from pedido;
delete from item_pedido;
delete from grupo_permissoes;

set foreign_key_checks = 1;

alter table cidade auto_increment = 1;
alter table cozinha auto_increment = 1;
alter table estado auto_increment = 1;
alter table forma_pagamento auto_increment = 1;
alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table produto auto_increment = 1;
alter table restaurante auto_increment = 1;
alter table usuario auto_increment = 1;
alter table pedido auto_increment = 1;
alter table item_pedido auto_increment = 1;





INSERT into cozinha (id,nome) VALUES (1,'tailandesa');
INSERT into cozinha (id,nome) VALUES (2,'indiana');
INSERT into cozinha (id,nome) VALUES (3,'mexicana');
INSERT into cozinha (id,nome) VALUES (4,'arabe');
INSERT into forma_pagamento (id,descricao) VALUES (1,'cartao debito');
INSERT into forma_pagamento (id,descricao) VALUES (2,'pix');
INSERT into forma_pagamento (id,descricao) VALUES (3,'cartao credito');
INSERT into estado (id,nome)  VALUES (1,'RS');
INSERT into estado (id,nome)  VALUES (2,'SC');
INSERT into estado (id,nome)  VALUES (3,'PR');
INSERT into estado (id,nome)  VALUES (4,'SP');
INSERT INTO cidade (id,nome,estado_id) VALUES (1,'porto alegre',1);
INSERT INTO cidade (id,nome,estado_id) VALUES (2,'viamao',1);
INSERT INTO cidade (id,nome,estado_id) VALUES (3,'canoas',1);
INSERT INTO cidade (id,nome,estado_id) VALUES (4,'gravatai',1);
INSERT into restaurante (nome,taxa_frete,cozinha_id,data_cadastro,data_atualizacao) VALUES ('thai gourmet',10,1,utc_timestamp,utc_timestamp);
INSERT into restaurante (nome,taxa_frete,cozinha_id,data_cadastro,data_atualizacao) VALUES ('thai delivery',9.50,1,utc_timestamp,utc_timestamp);
INSERT into restaurante (nome,taxa_frete,cozinha_id,data_cadastro,data_atualizacao) VALUES ('tuk tuk comida',15,2,utc_timestamp,utc_timestamp);
INSERT INTO `restaurante_forma_pagamento` (`forma_pagamento_id`, `restaurante_id`) VALUES ('1', '1'), ('1', '2'),('1','3'),('3','1'),('2','1');