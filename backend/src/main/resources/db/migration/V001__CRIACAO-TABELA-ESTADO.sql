create table estado (
    id bigint auto_increment,
    nome varchar(255) not null ,
    sigla varchar(2) not null ,
    
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;