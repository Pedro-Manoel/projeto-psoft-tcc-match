-- Caixa de E-mail do coordenador
insert into CAIXA_EMAIL(ID) values(0);

-- Coordenador
-- Email: admin@email.com.br
-- Senha: admin
INSERT INTO USUARIO(DTYPE, ID, EMAIL, NOME, SENHA, MATRICULA, PERIODO_PREVISTO_CONCLUSAO, LABORATORIOS, QUOTA, CAIXA_EMAIL_ID)
VALUES
       ('Coordenador', 0, 'admin@email.com.br', 'Admin', '$2a$10$HXVZlUDHZF4B3taAqf3jtuL7aAyW4qb.fm14qyQOnsDoZOJbZkvJy', null, null, null, null, 0);

