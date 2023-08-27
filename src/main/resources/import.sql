INSERT into tab_cozinha (id,nom_cozinha) VALUES (1,'tailandesa')
INSERT into tab_cozinha (id,nom_cozinha) VALUES (2,'Indiana')
INSERT into tab_cozinha (id,nom_cozinha) VALUES (3,'mexicana')
INSERT into tab_cozinha (id,nom_cozinha) VALUES (4,'arabe')

INSERT into tab_forma_pagamento (id,descricao) VALUES (1,'cartao debito')
INSERT into tab_forma_pagamento (id,descricao) VALUES (2,'pix')
INSERT into tab_forma_pagamento (id,descricao) VALUES (3,'cartao credito')

INSERT into tab_estado (id,nome)  VALUES (1,'RS')
INSERT into tab_estado (id,nome)  VALUES (2,'SC')
INSERT into tab_estado (id,nome)  VALUES (3,'PR')
INSERT into tab_estado (id,nome)  VALUES (4,'SP')

INSERT INTO tab_cidade (id,nome,estado_id) VALUES (1,'porto alegre',1)
INSERT INTO tab_cidade (id,nome,estado_id) VALUES (2,'viamao',1)
INSERT INTO tab_cidade (id,nome,estado_id) VALUES (3,'canoas',1)
INSERT INTO tab_cidade (id,nome,estado_id) VALUES (4,'gravatai',1)

INSERT into tab_restaurante (nome,taxa_frete,cozinha_id,data_cadastro,data_atualizacao) VALUES ('thai gourmet',10,1,utc_timestamp,utc_timestamp);
INSERT into tab_restaurante (nome,taxa_frete,cozinha_id,data_cadastro,data_atualizacao) VALUES ('thai delivery',9.50,1,utc_timestamp,utc_timestamp);
INSERT into tab_restaurante (nome,taxa_frete,cozinha_id,data_cadastro,data_atualizacao) VALUES ('tuk tuk comida',15,2,utc_timestamp,utc_timestamp);

INSERT INTO `restaurante_forma_pagamento,` (`forma_pagamento_id`, `restaurante_id`) VALUES ('1', '1'), ('1', '2'),('1','3'),('3','1'),('2','1');


update cidade c set c.estado_id = (select e.id from estado e where e.nome = c.nome_estado);