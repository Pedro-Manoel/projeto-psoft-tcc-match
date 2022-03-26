<div align="center">
  <h1>📃 TCC Match</h1>
  <p>Projeto da disciplina de Projeto de Software (Psoft) - UFCG</p>
</div>

## 📑 Sumário

- [Sobre](#sobre)
- [User Stories](#userStories)
- [Como executar ?](#usage)
- [Tecnologias](#tecs)
- [Autores](#authors)

## 🔖 Sobre <a name = "sobre"></a>

O sistema TCC Match tem o objetivo de permitir que alunos busquem e sugiram temas, encontrem professores dispostos a orientar em áreas específicas, de forma a facilitar o processo de orientação nas disciplinas de Pré-TCC e TCC, tanto para alunos e professores quanto para a coordenação.

## 📒 User Stories <a name = "userStories"></a><br>

**US1.** Eu, como coordenador e administrador, gostaria de ter o sistema armazenando todos os seus dados de forma persistente em um banco de dados.

**US2.** Eu, como coordenador e administrador, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas ao administrador. 

**US3.** Eu, como administrador, gostaria de acessar o sistema através de um link na web, preferencialmente usando o Heroku (outras opções de deploy podem ser usadas). Obs.: esta US é opcional, mas recomenda-se que seja realizada.

**US4.** Eu, como coordenador e administrador, gostaria de cadastrar um aluno do curso de Ciência da Computação no sistema, informando nome completo, matrícula, email e período previsto para a conclusão do curso.

**US5.** Eu, como coordenador e administrador, gostaria de atualizar ou remover o cadastro de um aluno do curso. Para tal, o aluno deve estar cadastrado no sistema.

**US6.** Eu, como coordenador e administrador, gostaria de cadastrar um professor do curso de Ciência da Computação no sistema, informando nome completo, email e laboratórios do qual faz parte.

**US7.** Eu, como coordenador e administrador, gostaria de atualizar ou remover o cadastro de um professor do curso. Para tal, o professor deve estar cadastrado no sistema.

**US8.** Eu, como coordenador e administrador, gostaria de cadastrar áreas de estudo em Ciência da Computação (e.g. engenharia de software, banco de dados, etc.) disponíveis para o desenvolvimento de TCCs.

**US9.** Eu, como aluno, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas aos alunos.

**US10.** Eu, como aluno, gostaria de selecionar áreas de estudo, em Ciência da Computação, que tenho interesse em realizar meu TCC.

**US11.** Eu, como aluno, gostaria de listar professores, com seus respectivos contatos, que tenham interesse e disponibilidade (quota) para orientar temas de TCC nas minhas áreas de interesse. 

**US12.** Eu, como aluno, gostaria de cadastrar uma proposta de tema de TCC, informando título, descrição, status do trabalho e áreas de estudo relacionadas.

**US13.** Eu, como aluno, gostaria de listar temas de TCC cadastrados pelos professores do curso, com informações de título, áreas de conhecimento e professor responsável.

**US14.** Eu, como aluno, gostaria de solicitar orientação em um tema de TCC cadastrado por um professor.

**US15.** Eu, como aluno, gostaria de ser notificado por email caso um novo tema de TCC nas minhas áreas de interesse seja cadastrado por um professor. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.

**US16.** Eu, como aluno, gostaria de ser notificado por email caso um professor manifeste interesse em orientar um tema de TCC cadastrado por mim. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.

**US17.** Eu, como aluno, gostaria de reportar à coordenação algum problema de orientação (e.g. indisponibilidade, comunicação, etc.)

**US18.** Eu, como professor, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas aos professores.

**US19.** Eu, como professor, gostaria de selecionar áreas de estudo, em Ciência da Computação, que tenho interesse em orientar temas de TCC.

**US20.** Eu, como professor, gostaria de configurar / atualizar minha disponibilidade para orientação de alunos no TCC (quota).

**US21.** Eu, como professor, gostaria de cadastrar um tema de TCC, informando título, descrição e áreas de estudo relacionadas.

**US22.** Eu, como professor, gostaria de listar os temas de TCC que eu cadastrei no sistema, com informações de título e áreas de conhecimento relacionadas.

**US23.** Eu, como professor, gostaria de listar os temas de TCC cadastrados pelos alunos, com informações de título e áreas de conhecimento relacionadas.

**US24.** Eu, como professor, gostaria de ser notificado por email caso um aluno solicite orientação em um tema de TCC cadastrado por mim. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.

**US25.** Eu, como professor, gostaria de poder listar solicitações de alunos para a orientação de temas de TCC cadastrados por mim.

**US26.** Eu, como professor, gostaria de poder aprovar ou negar uma solicitação de aluno para a orientação de um tema de TCC cadastrado por mim. A resposta a solicitação deve ser obrigatoriamente acompanhada de uma mensagem.

**US27.** Eu, como professor, gostaria de manifestar interesse em orientar um tema de TCC cadastrado por um aluno.

**US28.** Eu, como coordenador e administrador, gostaria de ser notificado por email caso um professor aceite uma solicitação de orientação realizada por um aluno. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema.

**US29.** Eu, como coordenador e administrador, gostaria de cadastrar uma orientação de TCC de um professor para um aluno, informado o período de realização do TCC.

**US30.** Eu, como coordenador e administrador, gostaria de finalizar uma orientação de TCC realizada, indicando o período do TCC.

**US31.** Eu, como professor, gostaria de listar minhas orientações em curso, que foram cadastradas pela coordenação.

**US32.** Eu, como professor, gostaria de reportar à coordenação algum problema na orientação (e.g. indisponibilidade, comunicação, frequência, etc.)

**US33.** Eu, como coordenador e administrador, gostaria de listar orientações em curso e finalizadas por semestre, com informações sobre aluno, orientador, tema e semestre do TCC.

**US34.** Eu, como coordenador e administrador, gostaria de gerar um relatório com as informações sobre as orientações de TCC em curso e finalizadas por semestre, destacando as áreas do conhecimento relacionadas.

**US35.** Eu, como coordenador e administrador, gostaria de gerar um relatório com os problemas de orientação apresentados no período, com separação de problemas reportados por alunos e professores.

## 💥 Como executar ? <a name="usage"></a>

- ### 👉 **Pré-requisitos**

  - É **necessário** possuir o **[Java](https://www.oracle.com/java/technologies/downloads//)** instalado no computador
  - É **necessário** possuir o **[Maven](https://maven.apache.org/install.html)** instalado no computador

1. Faça o clone do repositório:
	```sh
	  $ git clone https://github.com/psoft-2021-1/projeto-psoft-grupo-10.git
	```

2. Entre na pasta do projeto:
	```sh
	  $ cd projeto-psoft-grupo-10
	```
3. Execute o seguinte comando
	```sh
	  $ mvn spring-boot:run 
	```	

## 📗 Documentação (Swagger)

### 🔑 Login do Coordenador
> **E-mail:** fubica@ccc.ufcg.edu.br <br/> **Senha:** fubccc

### 🔗 Acesso Remoto (Online)
https://api-tcc-match.herokuapp.com/swagger-ui/index.html

### 🔗 Acesso Local (Offline)
https://localhost:8080/swagger-ui/index.html

## 🎲 Banco de Dados (H2)

### 🔑 Login
> **JDBC URL:** jdbc:h2:mem:db <br/> **User Name:** test <br/> **Password:** test

### 🔗 Acesso Remoto (Online)
https://api-tcc-match.herokuapp.com/h2
### 🔗 Acesso Local (Offline)
https://localhost:8080/h2

## 🚀 Tecnologias <a name="tecs"></a>

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework 
- [H2](https://www.h2database.com/html/main.html) - Banco de dados
- [Swagger](https://swagger.io/) - Documentação

## 🙆‍♀️ Autores: <a name= "authors"></a>

- [@lucasarlim](https://github.com/lucasarlim)
- [@viniciustrr](https://github.com/viniciustrr)
- [@Pedro-Manoel](https://github.com/Pedro-Manoel)
- [@Felipe1496](https://github.com/Felipe1496)
