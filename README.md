<h1 align="center">
Desafio de Desenvolvimento Java
</h1>

<p align="center">
  Criar uma API para uma seguradora de veículos.
</p>

<p align="center">
  <a href="#page_with_curl-sobre">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#books-dependencias">Dependencias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#star-requisitos">Requisitos</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;  
  <a href="#rocket-começando">Começando</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#computer-iniciando-o-projeto">Iniciando o Projeto</a>&nbsp;&nbsp;&nbsp;
</p>

## :page_with_curl: Sobre
Este repositório contém um sistema baseado em arquitetura Rest Api desenvolvida com Java e Spring Boot, o MongoDB para a persistência de dados, 
o Swagger e Insomnia para a documentação dos endpoints e models e o hibernate-validator e spring-validation para fazer as validações necessárias da Api.

## :books: **Dependencias**


**spring-boot-starter-web**: Utilizado para tornar a aplicação web.

**spring-boot-starter-data-mongodb**: Utilizado para fazer a integração com o MongoDB e gerenciar a persistência de dados do sistema.

**spring-boot-starter-validation**: Utilizado para as validações dos Models, DTOs, etc.

**hibernate-validator**: Utilizado para validação de CPF.

**springfox-swagger**: Utilizado para documentar a Api.

**spring-boot-devtools**: Utilizado para o LiveReload do servidor


## :star: Requisitos
- Ter [**Git**](https://git-scm.com/) para clonar o projeto.
- Ter [**Java 8**](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html) instalado.
- Ter [**MongoDB**](https://www.mongodb.com/try/download/community) instalado.
- Ter [**Gradle**](https://gradle.org/install/) instalado. (Opcional)


## :rocket: Começando
``` bash
  # Clonar o projeto:
  $ git clone https://github.com/Ricardohauus/desafio-viavarejo

  # Entrar no diretório do projeto:
  $ cd desafio-viavarejo  
```

## :computer: Iniciando o Projeto
```bash
  # Instalar as dependências:
  $ gradle build --refresh-dependencies 

  # Rodar a aplicação:
  $ gradle bootRun
```

Feito com ❤️ por Ricardo Brasil 👋🏻 [Get in touch!](https://github.com/Ricardohauus)
