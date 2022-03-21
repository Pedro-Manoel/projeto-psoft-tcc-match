-- Email: fubica@ccc.ufcg.edu.br
-- Senha: fubccc
insert into usuario(DTYPE, ID, EMAIL, NOME, SENHA, MATRICULA, PERIODO_PREVISTO_CONCLUSAO, LABORATORIOS, QUOTA)
    values('Coordenador', 0, 'fubica@ccc.ufcg.edu.br', 'Fubica', '$2a$10$/3DLKbuV76agb/OcBl9B4eRIKSl.EkPBm1diPgyIIJU39o1PCeyzK', null, null, null, null);


-- Testes
insert into usuario(DTYPE, ID, EMAIL, NOME, SENHA, MATRICULA, PERIODO_PREVISTO_CONCLUSAO, LABORATORIOS, QUOTA)
    values
           ('Professor', 1, 'test1', 'Fubica', '123', null, null, 'lab1', 0),
           ('Professor', 2, 'test2', 'Fubica', '123', null, null, 'lab1', 1),
           ('Professor', 3, 'test3', 'Fubica', '123', null, null, 'lab1', 2),
           ('Professor', 4, 'test4', 'Fubica', '123', null, null, 'lab1', 3),
           ('Professor', 5, 'test5', 'Fubica', '123', null, null, 'lab1', 4),
           ('Aluno', 6, 'test6', 'Fubica', '123', 'xxx', '2060', null, null),
           ('Aluno', 7, 'test7', 'Fubica', '123', 'xxx', '2060', null, null);

insert into AREA_ESTUDO (ID, NOME)
values
    (1, 'TC'),
    (2, 'LOAC'),
    (3, 'BD'),
    (4, 'SO'),
    (5, 'P1'),
    (6, 'P2'),
    (7, 'P3');

INSERT INTO USUARIO_AREAS_ESTUDO(USUARIO_TCC_ID, AREAS_ESTUDO_ID)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 2),
    (2, 6),
    (3, 4),
    (3, 5),
    (3, 6),
    (5, 5),
    (6, 1), -- Aluno
    (7, 2); -- Aluno

