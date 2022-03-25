-- Caixa de E-mail do coordenador
insert into CAIXA_EMAIL(ID) values(0);

-- Coordenador
-- Email: fubica@ccc.ufcg.edu.br
-- Senha: fubccc
INSERT INTO USUARIO(DTYPE, ID, EMAIL, NOME, SENHA, MATRICULA, PERIODO_PREVISTO_CONCLUSAO, LABORATORIOS, QUOTA, CAIXA_EMAIL_ID)
    values
           ('Coordenador', 0, 'fubica@ccc.ufcg.edu.br', 'Fubica', '$2a$10$/3DLKbuV76agb/OcBl9B4eRIKSl.EkPBm1diPgyIIJU39o1PCeyzK', null, null, null, null, 0);

