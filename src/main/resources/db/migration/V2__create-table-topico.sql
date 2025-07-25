create table topico(

   id bigint not null auto_increment,
   titulo varchar(100) not null unique,
   mensagem varchar(100) not null unique,
   data_criacao datetime not null,
   autor_id bigint not null,
   curso varchar(100) not null,
   respostas_id bigint not null,

   primary key(id)
);
