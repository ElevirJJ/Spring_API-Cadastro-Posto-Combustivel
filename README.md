⛽ Spring API Posto de Combustível

API REST desenvolvida em Java com Spring Boot, com o tema de posto de combustível, implementando CRUD completo utilizando os principais verbos HTTP:

GET • POST • PUT • DELETE

O projeto foi criado para fins de estudo, focando em:

boas práticas de arquitetura

organização em camadas

autenticação segura com JWT RS256

versionamento de banco com Flyway

🚀 Tecnologias Utilizadas

Java

Spring Boot

Spring Web

Spring Data JPA

Spring Security

OAuth2 Resource Server

JWT (RS256)

Flyway Migration

MySQL

Swagger / OpenAPI

Maven

🔐 Segurança

O projeto utiliza Spring Security com OAuth2 Resource Server, implementando autenticação baseada em JWT.

Características

✔ Tokens JWT assinados com RSA (RS256)

✔ Autenticação via login

✔ Endpoints protegidos

✔ Validação com chave pública

✔ Token gerado com chave privada

Header de autenticação
Authorization: Bearer SEU_TOKEN_AQUI

⚠️ Atenção

As chaves RSA estão versionadas apenas para fins de estudo.
Nunca utilize este padrão em produção.

📦 Funcionalidades

✔ Cadastro de usuários

✔ Autenticação com JWT

✔ CRUD de tipos de combustível

✔ CRUD de bombas de combustível

✔ Registro de abastecimentos

✔ Relacionamento entre bomba e combustível

✔ Persistência com MySQL

✔ Versionamento de banco com Flyway

✔ Documentação automática com Swagger

🧱 Estrutura da API

A aplicação segue arquitetura em camadas:

config
 └── SecurityConfig

controller
 ├── FuelPumpsController
 ├── FuelTypesController
 ├── SupplyController
 ├── TokenController
 └── UserController

domain
 ├── dto
 └── entity

service
 ├── FuelPumpsService
 ├── FuelTypesService
 └── SupplyService

repository
 ├── FuelPumpsRepository
 ├── FuelTypesRepository
 ├── SupplyRepository
 └── UserRepository

resources
 └── db.migration
📄 Exemplos de JSON (Requests)
⛽ Tipo de Combustível
{
  "nome": "Gasolina Comum",
  "precoPorLitro": 5.4
}
⛽ Bomba de Combustível
{
  "nome": "teste",
  "tipos_compustivel": {
    "id": 1
  }
}
⛽ Abastecimento
{
  "idBomba": 2,
  "litragem": 100
}
👤 Usuário
{
  "nome": "elevir",
  "senha": "123"
}
📚 Documentação da API

A API possui documentação automática utilizando Swagger.

Após iniciar o projeto, acesse:

http://localhost:8080/swagger-ui/index.html
🗄 Banco de Dados

O banco utilizado é MySQL, com versionamento utilizando Flyway Migration.

Estrutura das migrations:

db.migration

V1__fuelPumps.sql
V2__supply.sql
V3__fuelTypes.sql
V4__userTB.sql
▶️ Como Executar o Projeto
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/api-posto-combustivel.git
2️⃣ Configurar o banco de dados

Editar o arquivo:

application.properties

Exemplo:

spring.datasource.url=jdbc:mysql://localhost:3306/posto
spring.datasource.username=root
spring.datasource.password=123
3️⃣ Executar o projeto
mvn spring-boot:run

A API estará disponível em:

http://localhost:8080

💻 Projeto desenvolvido para estudo de Java, Spring Boot e segurança com JWT RS256.
