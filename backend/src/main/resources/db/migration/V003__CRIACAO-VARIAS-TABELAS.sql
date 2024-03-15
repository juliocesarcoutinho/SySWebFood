create table forma_pagamento
(
    id        bigint       not null auto_increment,
    descricao varchar(100) not null,
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;

create table grupo
(
    id   bigint not null auto_increment,
    nome varchar(80),
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;

create table permissao
(
    id        bigint       not null auto_increment,
    descricao varchar(100) not null,
    nome      varchar(100) not null,
    primary key (id)
)engine=InnoDB DEFAULT CHARSET=UTF8;

create table permissao_grupo
(
    grupo_id     bigint not null,
    permissao_id bigint not null
) engine=InnoDB DEFAULT CHARSET=UTF8;

create table produto
(
    id             bigint not null auto_increment,
    ativo          bit,
    descricao      varchar(160),
    nome           varchar(160),
    preco          decimal(19, 2),
    restaurante_id bigint not null,
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE cozinha (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         nome VARCHAR(100) NOT NULL
);

create table restaurante
(
    id                   bigint         not null auto_increment,
    data_atualizacao     datetime       not null,
    data_cadastro        datetime       not null,
    endereco_bairro      varchar(120),
    endereco_cep         varchar(9),
    endereco_complemento varchar(120),
    endereco_logradouro  varchar(120),
    endereco_numero      varchar(60),
    nome                 varchar(120)   not null,
    taxa_frete           decimal(19, 2) not null,
    cozinha_id           bigint         not null,
    endereco_cidade_id   bigint,
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;

create table restaurante_forma_pagamento
(
    restaurante_id     bigint not null,
    forma_pagamento_id bigint not null
) engine=InnoDB DEFAULT CHARSET=UTF8;

create table usuario
(
    id            bigint not null auto_increment,
    data_cadastro datetime,
    email         varchar(120),
    nome          varchar(120),
    senha         varchar(120),
    primary key (id)
) engine=InnoDB DEFAULT CHARSET=UTF8;

create table usuario_grupo
(
    usuario_id bigint not null,
    grupo_id   bigint not null
) engine=InnoDB DEFAULT CHARSET=UTF8;

# alter table cidade
    #     add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado (id);
# alter table permissao_grupo
    #     add constraint FKbg6ckxdkau6gs4xrni3klmj8x foreign key (permissao_id) references permissao (id);
# alter table permissao_grupo
    #     add constraint FKc4yjj3ijp5fd2kkp2yis6b598 foreign key (grupo_id) references grupo (id);
# alter table produto
    #     add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante (id);
# alter table restaurante
    #     add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha (id);
# alter table restaurante
    #     add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade (id);
# alter table restaurante_forma_pagamento
    #     add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento (id);
# alter table restaurante_forma_pagamento
    #     add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante (id);
# alter table usuario_grupo
    #     add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo (id);
# alter table usuario_grupo
    #     add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario (id);

alter table permissao_grupo add constraint fk_grupo_permissao_permissao
    foreign key (permissao_id) references permissao (id);

alter table permissao_grupo add constraint fk_grupo_permissao_grupo
    foreign key (grupo_id) references grupo (id);

alter table produto add constraint fk_produto_restaurante
    foreign key (restaurante_id) references restaurante (id);

alter table restaurante add constraint fk_restaurante_cozinha
    foreign key (cozinha_id) references cozinha (id);

alter table restaurante add constraint fk_restaurante_cidade
    foreign key (endereco_cidade_id) references cidade (id);

alter table restaurante_forma_pagamento add constraint fk_rest_forma_pagto_forma_pagto
    foreign key (forma_pagamento_id) references forma_pagamento (id);

alter table restaurante_forma_pagamento add constraint fk_rest_forma_pagto_restaurante
    foreign key (restaurante_id) references restaurante (id);

alter table usuario_grupo add constraint fk_usuario_grupo_grupo
    foreign key (grupo_id) references grupo (id);

alter table usuario_grupo add constraint fk_usuario_grupo_usuario
    foreign key (usuario_id) references usuario (id);
