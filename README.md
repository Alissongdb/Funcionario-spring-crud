# CRUD de Funcionário com Java Spring Boot

Este projeto implementa um **CRUD** (Create, Read, Update, Delete) de funcionários utilizando **Java Spring Boot**, **PostgreSQL**, **DTO (Data Transfer Object)**, **ModelMapper** e **Migrações** de banco de dados.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL** (como banco de dados)
- **ModelMapper** (para mapeamento de objetos)
- **Flyway** (para migração do banco de dados)
- **Maven** (para gerenciamento de dependências)

## Funcionalidades

O projeto oferece as seguintes funcionalidades de CRUD:

- **Cadastrar** um funcionário (POST)
- **Buscar** todos os funcionários ou um funcionário específico por ID (GET)
- **Atualizar** um funcionário (PUT)
- **Deletar** um funcionário (DELETE)

Além disso, o projeto utiliza **DTOs** para transferir dados entre a camada de serviço e a camada de apresentação (API), e o **ModelMapper** é utilizado para mapear as entidades para os DTOs e vice-versa.

## Como Rodar o Projeto

### Pré-requisitos

1. **Java 17** ou superior
2. **PostgreSQL** instalado e configurado (database = Funcionarios)
3. **Maven** para gerenciamento de dependências

### Configuração do Banco de Dados

Este projeto utiliza o **PostgreSQL**. Para rodar o projeto, você deve configurar as credenciais do banco de dados no arquivo `application.properties`:

```properties
spring.application.name=crud-funcionario

spring.datasource.url=jdbc:postgresql://localhost:5432/Funcionarios
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver


spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
spring.flyway.locations=classpath:db/migration
spring.flyway.validate-on-migrate=false

