<h1>Challenge Fórum Hub</h1>

<h2> 📌 Descrição do projeto</h2>

<p>Desafio realizado como parte do Challenge Back End da Alura. </p>

<p>
  Esse desafio tem o objetivo de desenvolver uma API RESTful que replica o funcionamento do Back end de um fórum online.
  Essa API se concentrará especificamente no CRUD de tópicos de discussão do fórum.  
</p>

<h2>:hammer: Funcionalidades do projeto </h2>

- `POST /login`: Cria o token JWT para um usuário cadastrado acessar a API.
- `POST /topicos`: Cria um novo tópico.
- `GET /topicos`: Mostra todos os tópicos criados.
- `GET /topicos/nomeCurso/{nomeCurso}`: Listagem de tópicos por nome do curso.
- `PUT /topicos/{id}`: Atualizar dados de um tópico por id. Somente usuário com role administrador ou o autor do tópico que tem permissão para realizar essa requisição.
- `GET /topicos/{id}`: Mostrar dados de um tópico por id.
- `DELETE /topicos/{id}`: Deletar dados de um tópico por id. Somente usuário com role administrador tem permissão para realizar essa requisição.

<h2> 🧠 Tecnologias utilizadas </h2>

- Java 21 (Java SE)
- Spring Boot
- Spring Data JPA/Hibernate
- Maven
- Lombok
- Spring Web
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security
- Insomnia



