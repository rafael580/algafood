
 CREATE TABLE `cidade`(
  `id`      BIGINT          NOT NULL    AUTO_INCREMENT,
    `nome`    VARCHAR(50)     NOT NULL,
  	`estado_id`  bigint     NOT NULL,

     PRIMARY KEY (`id`),
     constraint fk_cidade_estado  foreign key (estado_id) references estado(id)
  );


