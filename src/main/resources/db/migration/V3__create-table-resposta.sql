create table resposta(

   id bigint not null auto_increment,
   mensagem varchar(100) not null unique,
   topico varchar(100) not null unique,
   data_criacao datetime not null,
   autor_id bigint not null,
   solucao boolean not null,

   primary key(id)
);
