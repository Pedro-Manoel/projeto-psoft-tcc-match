insert into CAIXA_EMAIL(ID) values(0);

-- Email: fubica@ccc.ufcg.edu.br
-- Senha: fubccc
insert into usuario(DTYPE, ID, EMAIL, NOME, SENHA, MATRICULA, PERIODO_PREVISTO_CONCLUSAO, LABORATORIOS, QUOTA, CAIXA_EMAIL_ID)
    values('Coordenador', 0, 'fubica@ccc.ufcg.edu.br', 'Fubica', '$2a$10$/3DLKbuV76agb/OcBl9B4eRIKSl.EkPBm1diPgyIIJU39o1PCeyzK', null, null, null, null, 0);


-- Testes

insert into CAIXA_EMAIL(ID)
values
       (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7);
insert into usuario(DTYPE, ID, EMAIL, NOME, SENHA, MATRICULA, PERIODO_PREVISTO_CONCLUSAO, LABORATORIOS, QUOTA, CAIXA_EMAIL_ID)
    values
           ('Professor', 1, 'test1', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', null, null, 'lab1', 0, 1),
           ('Professor', 2, 'test2', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', null, null, 'lab1', 1, 2),
           ('Professor', 3, 'test3', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', null, null, 'lab1', 2, 3),
           ('Professor', 4, 'test4', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', null, null, 'lab1', 3, 4),
           ('Professor', 5, 'test5', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', null, null, 'lab1', 4, 5),
           ('Aluno', 6, 'test6', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', 'xxx', '2060', null, null, 6),
           ('Aluno', 7, 'test7', 'Fubica', '$2a$10$gGyVw6y8gRFfPijsjns9M.cYuOv.iAubA73u1IvUbmc/lUrRpUSmu', 'xxx', '2060', null, null, 7);

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
    (6, 2), -- Aluno
    (6, 3), -- Aluno
    (7, 2); -- Aluno

insert into TEMA_TCC(ID, DESCRICAO, STATUS, TITULO)
values
       (1, 'test', 'test', 'WEB'),
       (2, 'test', 'test', 'IA'),
       (3, 'test', 'test', 'MED');

INSERT INTO TEMA_TCC_AREAS_ESTUDO(TEMA_TCC_ID, AREAS_ESTUDO_ID)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

INSERT INTO USUARIO_TEMAS_TCC(USUARIO_TCC_ID, TEMAS_TCC_ID)
VALUES
       (1, 1);

