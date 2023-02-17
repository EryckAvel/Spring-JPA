CREATE TABLE cidade(
    id_cidade bigint not null primary key,
    nome varchar(100),
    qtd_habitantes bigint
);

INSERT INTO cidade
    (id_cidade, nome, qtd_habitantes)
VALUES
    (1, 'Fortaleza', 300000),
    (2, 'Sobral', 100000),
    (3, 'Crato', 200000)