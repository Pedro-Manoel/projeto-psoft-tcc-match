<div align="center">
  <h1>📃 Sistema de TCC</h1>
  <p>Projeto da disciplina de Projeto de Software - UFCG</p>
</div>

<p align="center">
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/psoft-2021-1/projeto-psoft-grupo-10?style=flat-square">
    <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/psoft-2021-1/projeto-psoft-grupo-10?style=flat-square">
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/psoft-2021-1/projeto-psoft-grupo-10?style=flat-square">
    <img alt="GitHub license" src="https://img.shields.io/github/license/psoft-2021-1/projeto-psoft-grupo-10?style=flat-square"><br/>
</p>

## Sumário ![#3899F2](https://via.placeholder.com/10/3899F2/ffffff?text=+) 

- [Sobre](#sobre)
- [User Stories](#userStories)
- [Como executar ?](#usage)
- [Tecnologias](#tech_stack)
- [Autores](#authors)

## Sobre ![#3899F2](https://via.placeholder.com/10/3899F2/ffffff?text=+)  <a name = "sobre"></a>

O sistema TCC Match tem o objetivo de permitir que alunos busquem e sugiram temas, encontrem professores dispostos a orientar em áreas específicas, de forma a facilitar o processo de orientação nas disciplinas de Pré-TCC e TCC, tanto para alunos e professores quanto para a coordenação.
<br>

## User Stories ![#3899F2](https://via.placeholder.com/10/3899F2/ffffff?text=+) <a name = "userStories"></a><br>

US1. Eu, como coordenador e administrador, gostaria de ter o sistema armazenando todos os seus dados de forma persistente em um banco de dados. </br></br>
US2. Eu, como coordenador e administrador, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas ao administrador. </br></br>
US3. Eu, como administrador, gostaria de acessar o sistema através de um link na web, preferencialmente usando o Heroku (outras opções de deploy podem ser usadas). Obs.: esta US é opcional, mas recomenda-se que seja realizada. </br></br>
US4. Eu, como coordenador e administrador, gostaria de cadastrar um aluno do curso de Ciência da Computação no sistema, informando nome completo, matrícula, email e período previsto para a conclusão do curso. </br></br>
US5. Eu, como coordenador e administrador, gostaria de atualizar ou remover o cadastro de um aluno do curso. Para tal, o aluno deve estar cadastrado no sistema. </br></br>
US6. Eu, como coordenador e administrador, gostaria de cadastrar um professor do curso de Ciência da Computação no sistema, informando nome completo, email e laboratórios do qual faz parte. </br></br>
US7. Eu, como coordenador e administrador, gostaria de atualizar ou remover o cadastro de um professor do curso. Para tal, o professor deve estar cadastrado no sistema. </br></br>
US8. Eu, como coordenador e administrador, gostaria de cadastrar áreas de estudo em Ciência da Computação (e.g. engenharia de software, banco de dados, etc.) disponíveis para o desenvolvimento de TCCs. </br></br>
US9. Eu, como aluno, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas aos alunos. </br></br>
US10. Eu, como aluno, gostaria de selecionar áreas de estudo, em Ciência da Computação, que tenho interesse em realizar meu TCC. </br></br>
US11. Eu, como aluno, gostaria de listar professores, com seus respectivos contatos, que tenham interesse e disponibilidade (quota) para orientar temas de TCC nas minhas áreas de interesse.  </br></br>
US12. Eu, como aluno, gostaria de cadastrar uma proposta de tema de TCC, informando título, descrição, status do trabalho e áreas de estudo relacionadas. </br></br>
US13. Eu, como aluno, gostaria de listar temas de TCC cadastrados pelos professores do curso, com informações de título, áreas de conhecimento e professor responsável. </br></br>
US14. Eu, como aluno, gostaria de solicitar orientação em um tema de TCC cadastrado por um professor. </br></br>
US15. Eu, como aluno, gostaria de ser notificado por email caso um novo tema de TCC nas minhas áreas de interesse seja cadastrado por um professor. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema. </br></br>
US16. Eu, como aluno, gostaria de ser notificado por email caso um professor manifeste interesse em orientar um tema de TCC cadastrado por mim. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema. </br></br>
US17. Eu, como aluno, gostaria de reportar à coordenação algum problema de orientação (e.g. indisponibilidade, comunicação, etc.) </br></br>
US18. Eu, como professor, gostaria de logar no sistema, para ter acesso às funcionalidades destinadas aos professores. </br></br>
US19. Eu, como professor, gostaria de selecionar áreas de estudo, em Ciência da Computação, que tenho interesse em orientar temas de TCC. </br></br>
US20. Eu, como professor, gostaria de configurar / atualizar minha disponibilidade para orientação de alunos no TCC (quota). </br></br>
US21. Eu, como professor, gostaria de cadastrar um tema de TCC, informando título, descrição e áreas de estudo relacionadas. </br></br>
US22. Eu, como professor, gostaria de listar os temas de TCC que eu cadastrei no sistema, com informações de título e áreas de conhecimento relacionadas. </br></br>
US23. Eu, como professor, gostaria de listar os temas de TCC cadastrados pelos alunos, com informações de título e áreas de conhecimento relacionadas. </br></br>
US24. Eu, como professor, gostaria de ser notificado por email caso um aluno solicite orientação em um tema de TCC cadastrado por mim. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema. </br></br>
US25. Eu, como professor, gostaria de poder listar solicitações de alunos para a orientação de temas de TCC cadastrados por mim. </br></br>
US26. Eu, como professor, gostaria de poder aprovar ou negar uma solicitação de aluno para a orientação de um tema de TCC cadastrado por mim. A resposta a solicitação deve ser obrigatoriamente acompanhada de uma mensagem. </br></br>
US27. Eu, como professor, gostaria de manifestar interesse em orientar um tema de TCC cadastrado por um aluno. </br></br>
US28. Eu, como coordenador e administrador, gostaria de ser notificado por email caso um professor aceite uma solicitação de orientação realizada por um aluno. Obs.: o email não precisa de fato ser enviado, mas a informação de envio deve ser apresentada pelo sistema. </br></br>
US29. Eu, como coordenador e administrador, gostaria de cadastrar uma orientação de TCC de um professor para um aluno, informado o período de realização do TCC. </br></br>
US30. Eu, como coordenador e administrador, gostaria de finalizar uma orientação de TCC realizada, indicando o período do TCC. </br></br>
US31. Eu, como professor, gostaria de listar minhas orientações em curso, que foram cadastradas pela coordenação. </br></br>
US32. Eu, como professor, gostaria de reportar à coordenação algum problema na orientação (e.g. indisponibilidade, comunicação, frequência, etc.) </br></br>
US33. Eu, como coordenador e administrador, gostaria de listar orientações em curso e finalizadas por semestre, com informações sobre aluno, orientador, tema e semestre do TCC. </br></br>
US34. Eu, como coordenador e administrador, gostaria de gerar um relatório com as informações sobre as orientações de TCC em curso e finalizadas por semestre, destacando as áreas do conhecimento relacionadas. </br></br>
US35. Eu, como coordenador e administrador, gostaria de gerar um relatório com os problemas de orientação apresentados no período, com separação de problemas reportados por alunos e professores. </br></br>

## Como executar ? ![#3899F2](https://via.placeholder.com/10/3899F2/ffffff?text=+)  <a name="usage"></a>

## Tecnologias ![#3899F2](https://via.placeholder.com/10/3899F2/ffffff?text=+) <a name="tecs"></a>

[Spring Boot](https://spring.io/projects/spring-boot) - Framework </br> 
[H2](https://www.h2database.com/html/main.html) - Banco de dados </br> 
[Swagger](https://swagger.io/) - Documentação.

## Autores: ![#3899F2](https://via.placeholder.com/10/3899F2/ffffff?text=+)  <a name= "authors"></a>

- [@lucasarlim](https://github.com/lucasarlim)
- [@viniciustrr](https://github.com/viniciustrr)
- [@Pedro-Manoel](https://github.com/Pedro-Manoel)
- [@Felipe1496](https://github.com/Felipe1496)
