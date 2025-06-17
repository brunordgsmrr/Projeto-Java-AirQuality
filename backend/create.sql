
    create table tb_cidade (
        id integer not null,
        locality varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table tb_sensores (
        cidade_id integer,
        id integer not null,
        name varchar(255),
        primary key (id)
    );

    alter table if exists tb_sensores 
       add constraint FKceh15p7c63xchj1340j6k59wc 
       foreign key (cidade_id) 
       references tb_cidade;
