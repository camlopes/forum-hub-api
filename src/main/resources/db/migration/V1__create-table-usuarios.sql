create table usuarios(

    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    email varchar(100) not null unique,
    senha varchar(255) not null,
    perfil varchar(100) not null,

    primary key(id)

);