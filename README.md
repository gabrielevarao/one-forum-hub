---
<p align="center"> <b> <sup>ONE - Oracle Next Education | Alura | Especialização Back-end</sup></b></p> 
<h1 align="center">ForumHub</h1>

<div align="center">
  
![Static Badge](https://img.shields.io/badge/java-%236A5ACD?style=flat-square) 
![Static Badge](https://img.shields.io/badge/spring_boot-%232E8B57?style=flat-square)
![Static Badge](https://img.shields.io/badge/spring_data_jpa-%232F4F4F%09?style=flat-square)
![Static Badge](https://img.shields.io/badge/spring_security-red?style=flat-square)
![Static Badge](https://img.shields.io/badge/mysql-blue?style=flat-square)
![Static Badge](https://img.shields.io/badge/hibernate-8A2BE2?style=flat-square)
![Static Badge](https://img.shields.io/badge/jwt-gray?style=flat-square)

</div>

Este projeto é o back-end de uma API Rest que gerencia o fórum de uma plataforma educacional, em que usuários podem postar dúvidas e comentários diversos.

## 🔄 Funcionalidades
↳  Cadastro de usuário.\
↳  Login de usuário.\
↳  Postagem de tópico.\
↳  Consulta de tópico.\
↳  Listagem de tópicos ativos.\
↳  Atualização de tópico.\
↳  Exclusão (inativação) de tópico.

## 🌐 Endpoints
#### `/topicos` 
[GET] → listagem de tópicos\
[POST] → postagem de tópicos
#### `/topicos/{id}`
[GET] → consulta de tópico\
[PUT] → edição de tópico\
[DEL] → exclusão de tópico
#### `/cadastro`
[POST] → cadastro de usuários
#### `/login`
[POST] → login de usuários

## 🔒 Segurança
Somente usuários cadastrados podem interagir com a API.
> Autenticação feita por JWT (JSON Web Token).

## 🚥 Validações 
#### ⚠️ Acesso, edição e exclusão restritas aos autores das postagens
Usuários somente podem acessar e alterar os próprios tópicos.
#### ⚠️ Tópicos duplicados
Não é possível postar tópicos duplicados - com título e mensagem que já foram postados anteriormente.
#### ⚠️ Acesso a tópicos excluídos
Não são permitidos o acesso e a edição de tópicos deletados.

## 🔗 Tecnologias utilizadas
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Java Record (DTO)
- Hibernate
- Maven
- Flyway
- Lombok
- JWT
- MySQL
## 📚 Contexto
Este projeto é um dos desafios obrigatórios para a conclusão da _Tech Foundation_ - fase 3 da Especializa;áo Back-end do Programa ONE (Oracle Next Education).

---
