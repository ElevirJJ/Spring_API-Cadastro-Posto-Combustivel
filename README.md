# ⛽ API Cadastro de Posto de Combustível

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de um posto de combustível.

O sistema permite cadastrar:

- Tipos de combustível
- Bombas de combustível
- Abastecimentos
- Usuários para autenticação

Além disso, possui autenticação com **JWT**, tratamento global de exceções e versionamento do banco com **Flyway**.

---

# 🚀 Tecnologias utilizadas

- Java 23
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- MySQL
- Flyway
- Maven
- Lombok

---

# 📁 Estrutura do projeto

```bash
src/main/java
│
├── controller
│   ├── FuelPumpController
│   ├── SupplyController
│   ├── TokenController
│   ├── TypesFuelController
│   └── UserController
│
├── domain
│   ├── dto
│   │   ├── FuelPumpDTO
│   │   ├── SupplyDTO
│   │   ├── TypesFuelDTO
│   │   ├── LoginDTO
│   │   └── LoginResponse
│   │
│   └── entity
│       ├── FuelPump
│       ├── Supply
│       ├── TypesFuel
│       └── Usuario
│
├── service
│   ├── FuelPumpService
│   ├── SupplyService
│   └── TypesFuelService
│
├── repository
│   ├── FuelPumpRepository
│   ├── SupplyRepository
│   ├── TypesFuelRepository
│   └── UsuarioRepository
│
├── exception
│   ├── ErrorResponse
│   └── NotFoundException
│
└── handler
    └── GlobalExceptionHandler
```

---

# 🛠 Configuração do ambiente

## 1. Clonar o projeto

```bash
git clone URL_DO_SEU_REPOSITORIO
```

---

## 2. Configurar banco de dados MySQL

Crie um banco:

```sql
CREATE DATABASE posto_combustivel;
```

---

## 3. Configurar `application.properties`

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/posto_combustivel
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 4. Rodar aplicação

Via Maven:

```bash
./mvnw spring-boot:run
```

Ou pela IDE.

---

# 🔐 Autenticação

A API utiliza autenticação via **JWT**.

Fluxo:

1. Usuário realiza login
2. API gera token JWT
3. Token deve ser enviado no header:

```http
Authorization: Bearer SEU_TOKEN
```

---

# 📌 Endpoints principais

## Usuários

### Criar usuário

```http
POST /users
```

### Login

```http
POST /login
```

Body:

```json
{
  "login": "admin",
  "password": "123456"
}
```

---

## Tipos de Combustível

### Listar

```http
GET /types-fuel
```

### Criar

```http
POST /types-fuel
```

Exemplo:

```json
{
  "nome": "Gasolina"
}
```

---

## Bombas

### Listar

```http
GET /fuel-pump
```

### Criar

```http
POST /fuel-pump
```

Exemplo:

```json
{
  "nome": "Bomba 1",
  "typesFuelID": 1
}
```

---

## Abastecimentos

### Listar

```http
GET /supply
```

### Criar abastecimento

```http
POST /supply
```

Exemplo:

```json
{
  "fuelPumpID": 1,
  "litros": 20
}
```

---

# ⚠ Tratamento de erros

A aplicação possui tratamento global de exceções usando:

- `GlobalExceptionHandler`
- `NotFoundException`

Exemplo de retorno:

```json
{
  "message": "Combustível não encontrado",
  "status": 404
}
```

---

# 🗃 Versionamento do banco

O projeto utiliza **Flyway** para migrations.

Scripts atuais:

```bash
V1__create-table-types_fuel.sql
V2__create-table-supply.sql
```

---

# 📈 Melhorias futuras

- Testes unitários
- Swagger/OpenAPI
- Docker
- Deploy em nuvem
- Relatórios de abastecimento

---

# 👨‍💻 Autor

Desenvolvido por **Elevir Pereira**
