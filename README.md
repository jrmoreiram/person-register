# 👥 Person Register API

<div align="center">

![Java](https://img.shields.io/badge/Java-8-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.3.1-6DB33F?logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-336791?logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-2.9.2-85EA2D?logo=swagger&logoColor=black)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-green)

**API RESTful completa para cadastro e gerenciamento de pessoas**

[Funcionalidades](#-funcionalidades) • [Tecnologias](#%EF%B8%8F-tecnologias-utilizadas) • [Instalação](#-instalação) • [Endpoints](#-endpoints-da-api) • [Docker](#-docker)

</div>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#%EF%B8%8F-arquitetura)
- [Tecnologias Utilizadas](#%EF%B8%8F-tecnologias-utilizadas)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Configuração](#%EF%B8%8F-configuração)
- [Executando o Projeto](#-executando-o-projeto)
- [Endpoints da API](#-endpoints-da-api)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Modelo de Dados](#-modelo-de-dados)
- [Docker](#-docker)
- [CI/CD](#-cicd)
- [Testes](#-testes)
- [Monitoramento](#-monitoramento)
- [Documentação Swagger](#-documentação-swagger)
- [Exemplos de Uso](#-exemplos-de-uso)
- [Boas Práticas](#-boas-práticas)
- [Troubleshooting](#-troubleshooting)
- [Contribuindo](#-contribuindo)
- [Licença](#-licença)
- [Autor](#-autor)

---

## 📖 Sobre o Projeto

A **Person Register API** é uma API RESTful robusta e completa desenvolvida com **Spring Boot** para gerenciamento de cadastro de pessoas. O projeto demonstra a implementação de uma aplicação backend moderna utilizando as melhores práticas de desenvolvimento, incluindo:

- ✅ Arquitetura em camadas (Controller, Service, Repository)
- ✅ Padrão DTO (Data Transfer Object)
- ✅ Documentação automática com Swagger
- ✅ Containerização com Docker
- ✅ CI/CD com CircleCI
- ✅ Monitoramento com New Relic
- ✅ Testes automatizados com JUnit
- ✅ Cobertura de código com JaCoCo

### 🎯 Objetivos

- 🚀 Demonstrar desenvolvimento de API REST com Spring Boot
- 📚 Aplicar boas práticas de arquitetura de software
- 🔄 Implementar operações CRUD completas
- 📊 Incluir paginação e ordenação de resultados
- 🐳 Containerizar aplicação com Docker
- ✅ Garantir qualidade com testes automatizados
- 📈 Monitorar aplicação em produção

---

## ✨ Funcionalidades

### Operações CRUD

- ✅ **Criar Pessoa** - Cadastrar nova pessoa no sistema
- ✅ **Listar Pessoas** - Buscar todas as pessoas com paginação e ordenação
- ✅ **Buscar por ID** - Consultar pessoa específica
- ✅ **Atualizar Pessoa** - Modificar dados de pessoa existente
- ✅ **Deletar Pessoa** - Remover pessoa do sistema

### Recursos Avançados

- 📄 **Paginação** - Resultados paginados para grandes volumes
- 🔄 **Ordenação** - Ordenar por qualquer campo
- ✅ **Validação** - Bean Validation nos DTOs
- 🔍 **Swagger UI** - Documentação interativa da API
- 🐳 **Docker** - Container pronto para deploy
- 🔄 **CI/CD** - Pipeline automatizado com CircleCI
- 📊 **Monitoramento** - Integração com New Relic APM
- ✅ **Cobertura de Testes** - JaCoCo para métricas de código

---

## 🏗️ Arquitetura

### Arquitetura em Camadas

```
┌─────────────────────────────────────────────────────┐
│              REST API (Controller)                  │  ← Camada de Apresentação
│           PersonController.java                     │     Recebe requisições HTTP
└────────────────────┬────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────┐
│              Service Layer                          │  ← Camada de Negócio
│  PersonPersistenceService | PersonSearchService     │     Lógica de negócio
└────────────────────┬────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────┐
│           Repository Layer                          │  ← Camada de Persistência
│            PersonRepository.java                    │     Acesso a dados
└────────────────────┬────────────────────────────────┘
                     │
┌────────────────────▼────────────────────────────────┐
│           PostgreSQL Database                       │  ← Banco de Dados
│              Tabela: person                         │     Armazenamento
└─────────────────────────────────────────────────────┘
```

### Padrão DTO (Data Transfer Object)

```
API Request  →  PersonCreateDTO  →  Person (Entity)  →  Database
                                         ↓
API Response ←  PersonDTO        ←  Person (Entity)  ←  Database
```

**Por que usar DTOs?**
- 🔒 Segurança: Não expor entidade completa
- 🎯 Flexibilidade: Diferentes representações para entrada/saída
- 📦 Desacoplamento: API independente do modelo de dados

---

## 🛠️ Tecnologias Utilizadas

### Backend Framework
- **[Spring Boot 2.3.1](https://spring.io/projects/spring-boot)** - Framework principal
  - **Spring Web** - Criação de APIs REST
  - **Spring Data JPA** - Persistência e ORM
  - **Spring Validation** - Validação de dados
  - **Spring DevTools** - Hot reload em desenvolvimento

### Banco de Dados
- **[PostgreSQL](https://www.postgresql.org/)** - Banco de dados relacional
- **[Hibernate](https://hibernate.org/)** - ORM (Object-Relational Mapping)
- **[JPA](https://www.oracle.com/java/technologies/persistence-jsp.html)** - Java Persistence API

### Documentação
- **[Swagger 2.9.2](https://swagger.io/)** - Documentação OpenAPI
  - SpringFox Swagger2
  - Swagger UI - Interface interativa

### Ferramentas de Desenvolvimento
- **[Lombok](https://projectlombok.org/)** - Redução de boilerplate code
- **[ModelMapper 2.3.8](http://modelmapper.org/)** - Mapeamento objeto-objeto
- **[Maven](https://maven.apache.org/)** - Gerenciamento de dependências e build

### Containerização e Deploy
- **[Docker](https://www.docker.com/)** - Containerização da aplicação
- **[Terraform](https://www.terraform.io/)** - Infrastructure as Code (IaC)
- **[Heroku](https://www.heroku.com/)** - Plataforma de deploy

### CI/CD e Qualidade
- **[CircleCI](https://circleci.com/)** - Integração e entrega contínua
- **[JaCoCo 0.8.5](https://www.jacoco.org/)** - Cobertura de código
- **[JUnit 4](https://junit.org/junit4/)** - Testes automatizados

### Monitoramento
- **[New Relic](https://newrelic.com/)** - APM (Application Performance Monitoring)
  - Monitoramento de performance
  - Rastreamento de erros
  - Métricas de aplicação

---

## 📋 Pré-requisitos

### Software Necessário

- **[Java JDK 8+](https://www.oracle.com/java/technologies/downloads/)** - Linguagem de programação
- **[Maven 3.6+](https://maven.apache.org/download.cgi)** - Build tool (ou usar o wrapper mvnw incluído)
- **[PostgreSQL 9.6+](https://www.postgresql.org/download/)** - Banco de dados
- **[Docker](https://www.docker.com/get-started)** (opcional) - Para executar em container
- **[Git](https://git-scm.com/)** - Controle de versão

### Ferramentas Recomendadas

- **IDE:** IntelliJ IDEA, Eclipse ou VS Code com Java Extension Pack
- **Cliente REST:** Postman, Insomnia ou cURL
- **Cliente PostgreSQL:** pgAdmin, DBeaver ou psql

### Verificar Instalações

```bash
# Java
java -version

# Maven (ou usar mvnw incluído no projeto)
mvn -version

# PostgreSQL
psql --version

# Docker (opcional)
docker --version
docker-compose --version
```

---

## 🚀 Instalação

### 1. Clonar o Repositório

```bash
# Clonar ou extrair o projeto
git clone <url-do-repositorio>
cd person-register-master

# Ou extrair ZIP
unzip person-register-master.zip
cd person-register-master
```

### 2. Configurar Banco de Dados

#### Opção A: PostgreSQL Local

```bash
# Conectar ao PostgreSQL
psql -U postgres

# Criar banco de dados
CREATE DATABASE person_register;

# Criar usuário (opcional)
CREATE USER person_user WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE person_register TO person_user;
```

#### Opção B: Docker Compose (Recomendado)

Criar arquivo `docker-compose.yml`:

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:13-alpine
    container_name: person-register-db
    environment:
      POSTGRES_DB: person_register
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

Executar:
```bash
docker-compose up -d
```

### 3. Configurar Aplicação

Editar `src/main/resources/application.properties`:

```properties
# PostgreSQL local
spring.datasource.url=jdbc:postgresql://localhost:5432/person_register
spring.datasource.username=postgres
spring.datasource.password=postgres

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Server
server.port=8080
```

### 4. Instalar Dependências

```bash
# Usando Maven local
mvn clean install

# Ou usando Maven Wrapper (incluído no projeto)
./mvnw clean install  # Linux/Mac
mvnw.cmd clean install  # Windows
```

---

## ⚙️ Configuração

### application.properties

```properties
# ===== Banco de Dados =====
spring.jpa.database=POSTGRESQL
spring.datasource.platform=postgres
spring.database.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/person_register
spring.datasource.username=postgres
spring.datasource.password=postgres

# ===== JPA/Hibernate =====
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.format_sql=true

# ===== Servidor =====
server.port=8080

# ===== Logs =====
logging.level.com.junior.personcadastre=DEBUG
logging.level.org.hibernate.SQL=DEBUG
```

### Ambientes

#### Desenvolvimento (application-dev.properties)
```properties
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

#### Produção (application-prod.properties)
```properties
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
```

### Variáveis de Ambiente

```bash
# Definir variáveis de ambiente (mais seguro)
export DATASOURCE_URL=jdbc:postgresql://localhost:5432/person_register
export DATASOURCE_USERNAME=postgres
export DATASOURCE_PASSWORD=postgres
export SERVER_PORT=8080
```

---

## 🏃 Executando o Projeto

### Método 1: Maven (Desenvolvimento)

```bash
# Compilar e executar
mvn spring-boot:run

# Ou com Maven Wrapper
./mvnw spring-boot:run  # Linux/Mac
mvnw.cmd spring-boot:run  # Windows

# Com perfil específico
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Método 2: JAR Executável

```bash
# Compilar projeto
mvn clean package

# Executar JAR
java -jar target/person-cadastre-1.0.0.jar

# Com perfil de produção
java -jar -Dspring.profiles.active=prod target/person-cadastre-1.0.0.jar
```

### Método 3: Docker (Recomendado para Produção)

```bash
# Construir imagem Docker
docker build -t person-register-api:1.0.0 .

# Executar container
docker run -d \
  --name person-register-api \
  -p 8080:8080 \
  -e DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/person_register \
  -e DATASOURCE_USERNAME=postgres \
  -e DATASOURCE_PASSWORD=postgres \
  person-register-api:1.0.0

# Ver logs
docker logs -f person-register-api
```

### Método 4: IDE

#### IntelliJ IDEA
1. Abrir projeto (File → Open → selecionar pasta)
2. Aguardar Maven sincronizar dependências
3. Localizar `PersonCadastreApplication.java`
4. Clicar com botão direito → Run
5. Ou usar atalho: `Shift + F10`

#### Eclipse
1. File → Import → Existing Maven Projects
2. Selecionar pasta do projeto
3. Aguardar build automático
4. Botão direito em `PersonCadastreApplication.java`
5. Run As → Spring Boot App

### Acessar Aplicação

Após iniciar, a API estará disponível em:

- **API Base:** `http://localhost:8080`
- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **API Docs:** `http://localhost:8080/v2/api-docs`

---

## 🔗 Endpoints da API

### Base URL
```
http://localhost:8080/person
```

### Endpoints Disponíveis

| Método | Endpoint | Descrição | Body | Resposta |
|--------|----------|-----------|------|----------|
| `GET` | `/person` | Lista todas as pessoas (paginado) | - | 200 OK + PersonListDTO |
| `GET` | `/person/{id}` | Busca pessoa por ID | - | 200 OK + PersonDTO / 404 |
| `POST` | `/person/save` | Cria nova pessoa | PersonCreateDTO | 201 Created + PersonDTO |
| `PUT` | `/person/{id}` | Atualiza pessoa existente | PersonUpdateDTO | 200 OK + PersonDTO |
| `DELETE` | `/person/{id}` | Remove pessoa | - | 200 OK + mensagem |

### Parâmetros de Paginação

| Parâmetro | Tipo | Padrão | Descrição |
|-----------|------|--------|-----------|
| `page` | Integer | 0 | Número da página (inicia em 0) |
| `size` | Integer | 20 | Quantidade de itens por página |
| `sort` | String | id | Campo para ordenação |
| `direction` | String | ASC | Direção (ASC ou DESC) |

**Exemplo:**
```
GET /person?page=0&size=10&sort=firstName&direction=ASC
```

---

## 📁 Estrutura do Projeto

```
person-register-master/
│
├── .circleci/
│   └── config.yml                          # Configuração CircleCI
│
├── .mvn/                                   # Maven Wrapper
│   └── wrapper/
│       └── maven-wrapper.properties
│
├── .terraform/                             # Terraform para IaC
│
├── newrelic/                               # New Relic APM
│   ├── newrelic.yml                        # Configuração New Relic
│   └── README.txt
│
├── src/
│   ├── main/
│   │   ├── java/com/junior/personcadastre/
│   │   │   ├── api/
│   │   │   │   ├── controller/
│   │   │   │   │   └── PersonController.java        # REST Controller
│   │   │   │   ├── dto/
│   │   │   │   │   ├── PersonDTO.java               # DTO de resposta
│   │   │   │   │   ├── PersonCreateDTO.java         # DTO de criação
│   │   │   │   │   ├── PersonUpdateDTO.java         # DTO de atualização
│   │   │   │   │   ├── PersonListDTO.java           # DTO de lista paginada
│   │   │   │   │   ├── CollectionBaseDTO.java       # DTO base para coleções
│   │   │   │   │   └── ObjectBaseDTO.java           # DTO base para objetos
│   │   │   │   ├── mapper/
│   │   │   │   │   ├── PersonMapper.java            # Mapper Entity ↔ DTO
│   │   │   │   │   └── PageableMapper.java          # Mapper de paginação
│   │   │   │   └── param/
│   │   │   │       ├── PaginationParam.java         # Parâmetros de paginação
│   │   │   │       └── SortParam.java               # Parâmetros de ordenação
│   │   │   ├── config/
│   │   │   │   └── SwaggerConfig.java               # Configuração Swagger
│   │   │   ├── domain/
│   │   │   │   └── Person.java                      # Entidade JPA
│   │   │   ├── exception/
│   │   │   │   ├── BaseException.java               # Exceção base
│   │   │   │   ├── BadRequestException.java         # Exceção 400
│   │   │   │   └── NotFoundException.java           # Exceção 404
│   │   │   ├── repository/
│   │   │   │   └── PersonRepository.java            # Interface JPA Repository
│   │   │   ├── service/
│   │   │   │   ├── PersonPersistenceService.java    # Serviço de persistência
│   │   │   │   └── PersonSearchService.java         # Serviço de busca
│   │   │   └── PersonCadastreApplication.java       # Classe principal
│   │   └── resources/
│   │       └── application.properties               # Configurações
│   └── test/
│       └── java/com/junior/personcadastre/
│           ├── PersonCadastreApplicationTests.java  # Teste de contexto
│           ├── PersonControllerTest.java            # Teste de controller
│           ├── PersonPersistenceServiceTest.java    # Teste de persistência
│           └── PersonSearchServiceTest.java         # Teste de busca
│
├── .gitignore                              # Arquivos ignorados pelo Git
├── Dockerfile                              # Definição da imagem Docker
├── main.tf                                 # Configuração Terraform
├── pom.xml                                 # Configuração Maven
├── mvnw                                    # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                # Maven Wrapper (Windows)
└── README.md                               # Documentação original
```

---

## 💾 Modelo de Dados

### Entidade: Person

| Campo | Tipo | Descrição | Restrições |
|-------|------|-----------|------------|
| `id` | `Integer` | Identificador único | Primary Key, Auto Increment |
| `firstName` | `String` | Primeiro nome | NOT NULL |
| `lastName` | `String` | Sobrenome | NOT NULL |
| `personAge` | `Integer` | Idade da pessoa | NOT NULL, > 0 |

### Entidade JPA

```java
@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private int personAge;
}
```

### DTOs

#### PersonCreateDTO (Request - POST)
```json
{
  "firstName": "João",
  "lastName": "Silva",
  "personAge": 30
}
```

#### PersonUpdateDTO (Request - PUT)
```json
{
  "firstName": "João",
  "lastName": "Silva Santos",
  "personAge": 31
}
```

#### PersonDTO (Response)
```json
{
  "id": 1,
  "firstName": "João",
  "lastName": "Silva",
  "personAge": 30
}
```

#### PersonListDTO (Response - Lista Paginada)
```json
{
  "content": [
    {
      "id": 1,
      "firstName": "João",
      "lastName": "Silva",
      "personAge": 30
    },
    {
      "id": 2,
      "firstName": "Maria",
      "lastName": "Santos",
      "personAge": 25
    }
  ],
  "totalElements": 2,
  "totalPages": 1,
  "size": 20,
  "number": 0
}
```

---

## 📝 Exemplos de Uso

### 1. Criar Nova Pessoa

**cURL:**
```bash
curl -X POST http://localhost:8080/person/save \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "João",
    "lastName": "Silva",
    "personAge": 30
  }'
```

**Resposta:**
```json
{
  "id": 1,
  "firstName": "João",
  "lastName": "Silva",
  "personAge": 30
}
```

### 2. Listar Todas as Pessoas

**cURL:**
```bash
# Listar com paginação padrão
curl -X GET http://localhost:8080/person

# Com paginação customizada
curl -X GET "http://localhost:8080/person?page=0&size=10&sort=firstName&direction=ASC"
```

**Resposta:**
```json
{
  "content": [
    {
      "id": 1,
      "firstName": "João",
      "lastName": "Silva",
      "personAge": 30
    }
  ],
  "totalElements": 1,
  "totalPages": 1,
  "size": 20,
  "number": 0
}
```

### 3. Buscar Pessoa por ID

**cURL:**
```bash
curl -X GET http://localhost:8080/person/1
```

**Resposta:**
```json
{
  "id": 1,
  "firstName": "João",
  "lastName": "Silva",
  "personAge": 30
}
```

### 4. Atualizar Pessoa

**cURL:**
```bash
curl -X PUT http://localhost:8080/person/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "João",
    "lastName": "Silva Santos",
    "personAge": 31
  }'
```

**Resposta:**
```json
{
  "id": 1,
  "firstName": "João",
  "lastName": "Silva Santos",
  "personAge": 31
}
```

### 5. Deletar Pessoa

**cURL:**
```bash
curl -X DELETE http://localhost:8080/person/1
```

**Resposta:**
```
Person ID: 1 removed with success!
```

---

## 🐳 Docker

### Dockerfile

O projeto inclui um `Dockerfile` otimizado:

```dockerfile
FROM openjdk:8-jre-alpine
COPY ./target/person-cadastre-1.0.0.jar /opt/applications/
WORKDIR /opt/applications
ENTRYPOINT /usr/bin/java $JAVA_OPTS -jar person-cadastre-1.0.0.jar
```

### Construir Imagem

```bash
# 1. Compilar projeto
mvn clean package -DskipTests

# 2. Construir imagem Docker
docker build -t person-register-api:1.0.0 .

# 3. Verificar imagem criada
docker images | grep person-register
```

### Executar Container

```bash
# Executar container
docker run -d \
  --name person-api \
  -p 8080:8080 \
  -e DATASOURCE_URL=jdbc:postgresql://postgres:5432/person_register \
  -e DATASOURCE_USERNAME=postgres \
  -e DATASOURCE_PASSWORD=postgres \
  person-register-api:1.0.0

# Ver logs
docker logs -f person-api

# Parar container
docker stop person-api

# Remover container
docker rm person-api
```

### Docker Compose Completo

Criar `docker-compose.yml` completo:

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:13-alpine
    container_name: person-db
    environment:
      POSTGRES_DB: person_register
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    networks:
      - person-network

  api:
    build: .
    container_name: person-api
    ports:
      - "8080:8080"
    environment:
      DATASOURCE_URL: jdbc:postgresql://postgres:5432/person_register
      DATASOURCE_USERNAME: postgres
      DATASOURCE_PASSWORD: postgres
    depends_on:
      - postgres
    networks:
      - person-network

volumes:
  postgres_data:

networks:
  person-network:
    driver: bridge
```

**Executar:**
```bash
# Subir todos os serviços
docker-compose up -d

# Ver logs
docker-compose logs -f

# Parar todos os serviços
docker-compose down

# Parar e remover volumes
docker-compose down -v
```

---

## 🔄 CI/CD

### CircleCI

O projeto está configurado com **CircleCI** para integração contínua.

**Pipeline (.circleci/config.yml):**
```yaml
version: 2.1

orbs:
  maven: circleci/maven@0.0.12

workflows:
  maven_test:
    jobs:
      - maven/test  # checkout, build, test, upload results
```

**O que o pipeline faz:**
1. ✅ Checkout do código
2. ✅ Download de dependências Maven
3. ✅ Compilação do projeto
4. ✅ Execução de testes automatizados
5. ✅ Upload de resultados dos testes

### GitHub Actions (Alternativa)

Para adicionar GitHub Actions, criar `.github/workflows/ci.yml`:

```yaml
name: Java CI

on:
  push:
    branches: [ master, main ]
  pull_request:
    branches: [ master, main ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 8
      uses: actions/setup-java@v3
      with:
        java-version: '8'
        distribution: 'temurin'
        cache: maven
    
    - name: Build with Maven
      run: mvn clean install
    
    - name: Run tests
      run: mvn test
    
    - name: Generate coverage report
      run: mvn jacoco:report
    
    - name: Upload coverage to Codecov
      uses: codecov/codecov-action@v3
```

---

## ✅ Testes

### Estrutura de Testes

O projeto inclui testes automatizados para:
- ✅ Controller (PersonControllerTest)
- ✅ Service de Persistência (PersonPersistenceServiceTest)
- ✅ Service de Busca (PersonSearchServiceTest)
- ✅ Contexto da aplicação (PersonCadastreApplicationTests)

### Executar Testes

```bash
# Executar todos os testes
mvn test

# Executar teste específico
mvn test -Dtest=PersonControllerTest

# Executar testes com cobertura
mvn clean test jacoco:report

# Ver relatório de cobertura
open target/site/jacoco/index.html
```

### JaCoCo Coverage

O projeto usa **JaCoCo** para medir cobertura de código:

```bash
# Gerar relatório de cobertura
mvn jacoco:report

# Verificar cobertura mínima
mvn jacoco:check
```

**Relatório gerado em:**
- HTML: `target/site/jacoco/index.html`
- XML: `target/site/jacoco/jacoco.xml`

### Exemplo de Teste

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonPersistenceServiceTest {
    
    @Autowired
    private PersonPersistenceService persistenceService;
    
    @Test
    public void deveSalvarPessoaComSucesso() {
        // Arrange
        Person person = Person.PersonBuilder.of()
            .firstName("João")
            .lastName("Silva")
            .personAge(30)
            .build();
        
        // Act
        Person resultado = persistenceService.saveOrUpdatePerson(person);
        
        // Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals("João", resultado.getFirstName());
    }
}
```

---

## 📊 Monitoramento

### New Relic APM

O projeto está integrado com **New Relic** para monitoramento de performance.

**Recursos monitorados:**
- 📈 Tempo de resposta das requisições
- 🔍 Rastreamento de transações
- 💾 Uso de memória e CPU
- 🐛 Erros e exceções
- 📊 Throughput e taxa de erro
- 🗄️ Queries SQL e performance do banco

**Configuração:**
1. Criar conta no [New Relic](https://newrelic.com/)
2. Obter License Key
3. Configurar `newrelic/newrelic.yml`:
   ```yaml
   license_key: '<YOUR_LICENSE_KEY>'
   app_name: Person Register API
   ```

**Executar com New Relic:**
```bash
java -javaagent:newrelic/newrelic.jar -jar target/person-cadastre-1.0.0.jar
```

---

## 📖 Documentação Swagger

### Acessar Swagger UI

Após iniciar a aplicação, acesse:

**Swagger UI:** http://localhost:8080/swagger-ui.html

### Recursos do Swagger

- 📋 **Lista de todos os endpoints** com descrições
- 🧪 **Try it out** - Testar API diretamente pelo navegador
- 📝 **Modelos de dados** - Visualizar DTOs e entidades
- 📊 **Códigos de resposta** - Ver possíveis respostas HTTP
- 🔍 **Validações** - Ver regras de validação dos campos

### Configuração Swagger

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.junior.personcadastre.api.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Person Register API")
            .description("API RESTful para cadastro de pessoas")
            .version("1.0.0")
            .contact(new Contact("Júnior Moreira Martins", "", ""))
            .build();
    }
}
```

---

## 🔧 Recursos Técnicos Detalhados

### 1. Spring Data JPA

**Repository Pattern:**
```java
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // JpaRepository já fornece:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - count()
    // - exists()
    
    // Métodos customizados (query methods)
    List<Person> findByFirstName(String firstName);
    List<Person> findByPersonAgeGreaterThan(int age);
    Optional<Person> findByFirstNameAndLastName(String first, String last);
}
```

### 2. Lombok

**Redução de código boilerplate:**
```java
@Getter                    // Gera getters
@Setter                    // Gera setters
@NoArgsConstructor         // Construtor vazio
@AllArgsConstructor        // Construtor com todos os campos
@ToString                  // Método toString()
@EqualsAndHashCode         // equals() e hashCode()
@Data                      // Combinação de @Getter, @Setter, @ToString, etc
@Builder                   // Padrão Builder
public class Person {
    private String firstName;
    private String lastName;
}
```

### 3. ModelMapper

**Mapeamento automático entre objetos:**
```java
@Component
public class PersonMapper {
    
    private static ModelMapper mapper = new ModelMapper();
    
    public static PersonDTO fromEntity(Person entity) {
        return mapper.map(entity, PersonDTO.class);
    }
    
    public static Person fromCreateDTO(PersonCreateDTO dto) {
        return mapper.map(dto, Person.class);
    }
    
    public static List<PersonDTO> fromEntities(List<Person> entities) {
        return entities.stream()
            .map(PersonMapper::fromEntity)
            .collect(Collectors.toList());
    }
}
```

### 4. Bean Validation

**Validações automáticas:**
```java
public class PersonCreateDTO {
    
    @NotNull(message = "First name is required")
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    
    @Min(value = 0, message = "Age must be positive")
    @Max(value = 150, message = "Age must be realistic")
    private int personAge;
}
```

### 5. Exception Handling

**Tratamento centralizado de exceções:**
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        ErrorResponse error = new ErrorResponse(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex) {
        ErrorResponse error = new ErrorResponse(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        ErrorResponse error = new ErrorResponse(500, "Internal server error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
```

---

## 🎯 Padrões de Design Utilizados

### 1. Builder Pattern

```java
Person person = Person.PersonBuilder.of()
    .firstName("João")
    .lastName("Silva")
    .personAge(30)
    .build();
```

### 2. Repository Pattern

```java
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Abstrai acesso a dados
}
```

### 3. Service Layer Pattern

```java
@Service
public class PersonPersistenceService {
    // Lógica de negócio isolada
}
```

### 4. DTO Pattern

```java
// Separação entre entidade e API
PersonCreateDTO → Person → PersonDTO
```

### 5. Mapper Pattern

```java
public class PersonMapper {
    // Conversão entre objetos
}
```

---

## 📈 Boas Práticas Implementadas

### Arquitetura

- ✅ **Separação de responsabilidades** - Camadas bem definidas
- ✅ **Dependency Injection** - Injeção via Spring
- ✅ **Interface segregation** - Repositories e Services focados
- ✅ **DTO Pattern** - Desacoplamento API ↔ Domain

### Código

- ✅ **Lombok** - Redução de boilerplate
- ✅ **Builder Pattern** - Criação fluente de objetos
- ✅ **Validações** - Bean Validation nos DTOs
- ✅ **Exceções customizadas** - Tratamento específico de erros
- ✅ **Logging** - SLF4J para logs estruturados

### Banco de Dados

- ✅ **JPA/Hibernate** - ORM para abstração de BD
- ✅ **Transações** - `@Transactional` para atomicidade
- ✅ **Pool de conexões** - HikariCP (padrão Spring Boot)
- ✅ **Migrations** - DDL automático ou Flyway/Liquibase

### API

- ✅ **REST** - Seguindo princípios RESTful
- ✅ **HTTP Status corretos** - 200, 201, 400, 404, 500
- ✅ **Paginação** - Para grandes volumes de dados
- ✅ **Documentação** - Swagger para documentação viva
- ✅ **Versionamento** - Preparado para evolução

### DevOps

- ✅ **Docker** - Containerização
- ✅ **CI/CD** - Pipeline automatizado
- ✅ **IaC** - Terraform para infraestrutura
- ✅ **Monitoramento** - New Relic APM
- ✅ **Cobertura de testes** - JaCoCo

---

## 🐛 Troubleshooting

### Erro: Failed to configure a DataSource

**Problema:** Spring não consegue conectar ao banco de dados

**Solução:**
1. Verificar se PostgreSQL está rodando:
   ```bash
   # Linux/Mac
   sudo service postgresql status
   
   # Docker
   docker ps | grep postgres
   ```

2. Verificar credenciais em `application.properties`

3. Testar conexão manual:
   ```bash
   psql -h localhost -U postgres -d person_register
   ```

### Erro: Port 8080 already in use

**Problema:** Porta 8080 já está em uso

**Solução:**
```bash
# Opção 1: Mudar porta em application.properties
server.port=8081

# Opção 2: Matar processo na porta 8080
# Linux/Mac
lsof -ti:8080 | xargs kill -9

# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Erro: Table 'person' doesn't exist

**Problema:** Tabela não foi criada automaticamente

**Solução:**
```properties
# Forçar criação de tabelas
spring.jpa.hibernate.ddl-auto=create

# Ou usar update para ambiente de desenvolvimento
spring.jpa.hibernate.ddl-auto=update

# Produção: usar validate + scripts SQL
spring.jpa.hibernate.ddl-auto=validate
```

### Erro: Cannot resolve symbol 'lombok'

**Problema:** IDE não reconhece Lombok

**Solução:**
```bash
# IntelliJ IDEA
# 1. Instalar plugin Lombok
# 2. Enable Annotation Processing:
#    Settings → Build → Compiler → Annotation Processors → Enable

# Eclipse
# 1. Baixar lombok.jar
# 2. Executar: java -jar lombok.jar
# 3. Selecionar Eclipse e instalar
```

### Erro de Memória (OutOfMemoryError)

**Problema:** Aplicação sem memória suficiente

**Solução:**
```bash
# Aumentar heap size
java -Xms512m -Xmx1024m -jar target/person-cadastre-1.0.0.jar

# Com Docker
docker run -e JAVA_OPTS="-Xms512m -Xmx1024m" person-register-api:1.0.0
```

---

## 🚀 Deploy

### Heroku

O projeto está configurado com Terraform para deploy no Heroku.

```bash
# 1. Instalar Heroku CLI
curl https://cli-assets.heroku.com/install.sh | sh

# 2. Login
heroku login

# 3. Criar aplicação
heroku create person-register-api

# 4. Adicionar PostgreSQL
heroku addons:create heroku-postgresql:hobby-dev

# 5. Deploy
git push heroku master

# 6. Abrir aplicação
heroku open
```

### AWS (EC2 + RDS)

```bash
# 1. Criar instância EC2
# 2. Instalar Java e Docker
# 3. Criar RDS PostgreSQL
# 4. Configurar Security Groups
# 5. Deploy com Docker

docker run -d \
  -p 80:8080 \
  -e DATASOURCE_URL=jdbc:postgresql://<rds-endpoint>:5432/persondb \
  -e DATASOURCE_USERNAME=admin \
  -e DATASOURCE_PASSWORD=<password> \
  person-register-api:1.0.0
```

### Kubernetes

Criar `k8s-deployment.yaml`:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: person-register-api
spec:
  replicas: 3
  selector:
    matchLabels:
      app: person-register
  template:
    metadata:
      labels:
        app: person-register
    spec:
      containers:
      - name: api
        image: person-register-api:1.0.0
        ports:
        - containerPort: 8080
        env:
        - name: DATASOURCE_URL
          valueFrom:
            configMapKeyRef:
              name: app-config
              key: database.url
```

---

## 🔐 Segurança

### Recomendações

#### 1. Não commitar credenciais

```properties
# ❌ Nunca fazer isso
spring.datasource.password=senha123

# ✅ Usar variáveis de ambiente
spring.datasource.password=${DB_PASSWORD}
```

#### 2. Usar Spring Security (Adicionar)

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/swagger-ui.html").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}
```

#### 3. Validar entrada de dados

```java
// Sempre validar DTOs
@Valid PersonCreateDTO dto
```

#### 4. SQL Injection Protection

```java
// JPA/Hibernate protege automaticamente
// Evite queries nativas sem parametrização
```

---

## 📦 Build e Empacotamento

### Maven Build Lifecycle

```bash
# Limpar build anterior
mvn clean

# Compilar
mvn compile

# Executar testes
mvn test

# Empacotar (gera JAR)
mvn package

# Instalar no repositório local
mvn install

# Pipeline completo
mvn clean install

# Pular testes (não recomendado)
mvn clean package -DskipTests
```

### Estrutura do JAR

```bash
# Ver conteúdo do JAR
jar -tf target/person-cadastre-1.0.0.jar

# Extrair JAR
jar -xf target/person-cadastre-1.0.0.jar

# JAR é executável (Spring Boot)
java -jar target/person-cadastre-1.0.0.jar
```

---

## 📊 Métricas e Performance

### Endpoints de Actuator (Adicionar)

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

```properties
# Habilitar endpoints
management.endpoints.web.exposure.include=health,info,metrics,prometheus

# Acesso
# http://localhost:8080/actuator/health
# http://localhost:8080/actuator/metrics
```

### Métricas Importantes

- **Tempo de resposta médio:** < 100ms
- **Taxa de erro:** < 1%
- **Disponibilidade:** > 99.9%
- **Cobertura de testes:** > 80%

---

## 🎓 Conceitos Aplicados

### Spring Boot Features

| Feature | Uso no Projeto |
|---------|----------------|
| **Auto-Configuration** | Configuração automática de beans |
| **Embedded Server** | Tomcat embutido |
| **Starter Dependencies** | spring-boot-starter-web, -data-jpa |
| **Application Properties** | Configuração externalizada |
| **DevTools** | Hot reload em desenvolvimento |
| **Actuator** | Monitoramento e métricas |

### REST API Best Practices

- ✅ Uso correto de verbos HTTP (GET, POST, PUT, DELETE)
- ✅ Status codes apropriados (200, 201, 400, 404, 500)
- ✅ JSON como formato padrão
- ✅ Versionamento preparado (/v1/person)
- ✅ HATEOAS preparado (links para recursos relacionados)
- ✅ Paginação para coleções
- ✅ Filtros e ordenação

---

## 🔍 Próximas Melhorias

### Features

- [ ] Autenticação e autorização (JWT/OAuth2)
- [ ] Busca avançada com filtros múltiplos
- [ ] Upload de foto de perfil
- [ ] Validação de CPF/documento
- [ ] Endereço (relacionamento OneToMany)
- [ ] Soft delete (exclusão lógica)
- [ ] Auditoria (createdAt, updatedAt, createdBy)
- [ ] Versionamento de API (/v1, /v2)

### Técnicas

- [ ] Implementar HATEOAS completo
- [ ] Cache com Redis
- [ ] Rate limiting
- [ ] Logs estruturados (JSON)
- [ ] Migrations com Flyway
- [ ] GraphQL como alternativa
- [ ] WebSocket para notificações

### DevOps

- [ ] Kubernetes manifests
- [ ] Helm charts
- [ ] Prometheus + Grafana
- [ ] ELK Stack (Elasticsearch, Logstash, Kibana)
- [ ] API Gateway (Kong, Zuul)

---

## 📚 Recursos Adicionais

### Documentação

- **[Spring Boot Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/)** - Documentação oficial
- **[Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)** - Persistência
- **[Hibernate Docs](https://hibernate.org/orm/documentation/)** - ORM
- **[PostgreSQL Docs](https://www.postgresql.org/docs/)** - Banco de dados

### Tutoriais

- [Spring Boot REST API Tutorial](https://spring.io/guides/tutorials/rest/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
- [JPA and Hibernate Tutorial](https://www.baeldung.com/jpa-hibernate-tutorial)

### Cursos

- **[Alura - Formação Java](https://www.alura.com.br/)** - Base de Java
- **[Alura - Spring Framework](https://www.alura.com.br/)** - Spring completo
- **[Alura - API REST](https://www.alura.com.br/)** - Desenvolvimento de APIs

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'feat: adiciona busca por nome'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

### Padrões de Commit

Seguir [Conventional Commits](https://www.conventionalcommits.org/):

```
feat: adiciona novo endpoint de busca
fix: corrige erro ao deletar pessoa
docs: atualiza README com exemplos
refactor: melhora estrutura de pastas
test: adiciona testes do controller
chore: atualiza dependências
```

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

## 👨‍💻 Autor

**Júnior Moreira Martins**

- GitHub: [@jmmartins](https://github.com/jmmartins)
- LinkedIn: [Júnior Moreira Martins](https://www.linkedin.com/in/jumoreiram/)

---

## 🙏 Agradecimentos

- **[Alura](https://www.alura.com.br/)** - Pela formação em Java e Spring Boot
- **Spring Team** - Pelo framework excepcional
- **Comunidade Java** - Por todo conhecimento compartilhado
- **PostgreSQL Team** - Pelo banco de dados robusto

---

## 📊 Estatísticas do Projeto

| Métrica | Valor |
|---------|-------|
| **Linguagem** | Java 8 |
| **Framework** | Spring Boot 2.3.1 |
| **Banco de Dados** | PostgreSQL |
| **Arquivos Java** | 20+ classes |
| **Testes** | 4 suites de teste |
| **Dependências** | 15+ bibliotecas |
| **Endpoints** | 5 endpoints REST |
| **Cobertura de código** | Configurado com JaCoCo |

---

## 🎯 Casos de Uso

### 1. Sistema de RH

- Cadastro de funcionários
- Gerenciamento de colaboradores
- Listagem com filtros
- Relatórios de pessoal

### 2. CRM (Customer Relationship Management)

- Cadastro de clientes
- Histórico de interações
- Segmentação de contatos
- Base de leads

### 3. Sistema Educacional

- Cadastro de alunos
- Gerenciamento de professores
- Lista de participantes
- Controle acadêmico

### 4. Plataforma de Eventos

- Inscrição de participantes
- Lista de presença
- Controle de credenciamento
- Certificados

---

## 🔧 Configurações Avançadas

### Profile de Desenvolvimento

```properties
# application-dev.properties
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### Profile de Produção

```properties
# application-prod.properties
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
logging.level.com.junior.personcadastre=INFO

# Connection pool
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000
```

### CORS Configuration

```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
```

---

## 📖 Comandos Úteis

### Maven

```bash
# Limpar e compilar
mvn clean compile

# Executar testes
mvn test

# Empacotar sem testes
mvn package -DskipTests

# Ver dependências
mvn dependency:tree

# Atualizar dependências
mvn versions:display-dependency-updates

# Executar aplicação
mvn spring-boot:run
```

### Docker

```bash
# Build
docker build -t person-api .

# Run
docker run -p 8080:8080 person-api

# Logs
docker logs -f <container-id>

# Entrar no container
docker exec -it <container-id> /bin/sh

# Parar e remover
docker stop <container-id>
docker rm <container-id>

# Limpar imagens não usadas
docker system prune -a
```

### PostgreSQL

```bash
# Conectar ao banco
psql -h localhost -U postgres -d person_register

# Listar tabelas
\dt

# Descrever tabela
\d person

# Consultar dados
SELECT * FROM person;

# Sair
\q
```

---

## 📈 Roadmap

### Versão 1.1.0
- [ ] Adicionar Spring Security
- [ ] Implementar JWT
- [ ] Adicionar validação de CPF
- [ ] Criar endpoint de busca por nome

### Versão 1.2.0
- [ ] Adicionar relacionamento com endereço
- [ ] Implementar cache com Redis
- [ ] Adicionar paginação melhorada
- [ ] Criar filtros dinâmicos

### Versão 2.0.0
- [ ] Migrar para Java 17
- [ ] Implementar GraphQL
- [ ] Adicionar WebSocket
- [ ] Implementar Event Sourcing

---

## 🔖 Tags e Versões

### Versionamento Semântico

```
MAJOR.MINOR.PATCH
  1  .  0  .  0

MAJOR: Breaking changes
MINOR: Novas features (compatível)
PATCH: Bug fixes
```

### Releases

- **v1.0.0** - Release inicial com CRUD completo
- **v1.0.1** - Correções de bugs
- **v1.1.0** - Adiciona autenticação
- **v2.0.0** - Migração para Java 17

---

<div align="center">

## 🌟 API REST Profissional com Spring Boot 🚀

**Desenvolvido com Java, Spring Boot e PostgreSQL**

### ⭐ Se este projeto foi útil, considere dar uma estrela!

### 📚 Continue aprendendo e construindo APIs robustas!

---

**"Uma boa API é invisível para quem usa, mas indispensável para quem desenvolve!"** 💡

**Spring Boot + PostgreSQL = ❤️**

![Spring Boot](https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg)

</div>

---

## 📞 Suporte

### Precisa de Ajuda?

- 📖 Consulte a [documentação do Spring Boot](https://docs.spring.io/spring-boot/)
- 🔍 Pesquise no [Stack Overflow](https://stackoverflow.com/questions/tagged/spring-boot)
- 💬 Participe da [comunidade Spring](https://spring.io/community)
- 📧 Abra uma issue neste repositório

### Comunidades Brasileiras

- [Spring Brasil](https://github.com/spring-projects-experimental)
- [Java Brasil no Discord](https://discord.gg/java-brasil)
- [Dev.to - Spring Boot PT-BR](https://dev.to/t/springboot)

---

## 🏆 Features Destacadas

### Padrão de Projeto Limpo

```
✅ Controllers magros (apenas roteamento)
✅ Services com lógica de negócio
✅ Repositories para acesso a dados
✅ DTOs para transferência de dados
✅ Mappers para conversões
✅ Exceptions customizadas
```

### Qualidade de Código

```
✅ Testes automatizados
✅ Cobertura de código (JaCoCo)
✅ CI/CD configurado
✅ Documentação Swagger
✅ Logs estruturados
✅ Monitoramento APM
```

### DevOps Ready

```
✅ Dockerfile otimizado
✅ Docker Compose para desenvolvimento
✅ Terraform para IaC
✅ CircleCI para CI/CD
✅ Deploy automático
```

---

## 🎨 Extensões Sugeridas

### 1. Adicionar Paginação Customizada

```java
@GetMapping("/search")
public ResponseEntity<Page<PersonDTO>> search(
    @RequestParam(required = false) String firstName,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "20") int size) {
    // Implementar busca com filtros
}
```

### 2. Adicionar Campos de Auditoria

```java
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Person {
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedBy
    private String lastModifiedBy;
}
```

### 3. Implementar DTO de Erro Padronizado

```java
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private List<String> errors;
}
```

---

## 📚 Glossário

| Termo | Descrição |
|-------|-----------|
| **API** | Application Programming Interface |
| **REST** | REpresentational State Transfer |
| **CRUD** | Create, Read, Update, Delete |
| **DTO** | Data Transfer Object |
| **JPA** | Java Persistence API |
| **ORM** | Object-Relational Mapping |
| **Bean** | Objeto gerenciado pelo Spring |
| **IoC** | Inversion of Control |
| **DI** | Dependency Injection |
| **APM** | Application Performance Monitoring |
| **CI/CD** | Continuous Integration/Continuous Delivery |

---

**📅 Última atualização:** Abril 2026  
**📌 Versão:** 1.0.0  
**✅ Status:** Produção Ready  
**🔧 Tecnologia:** Java 8 + Spring Boot 2.3.1 + PostgreSQL

---

**#Java #SpringBoot #REST #API #PostgreSQL #Docker #Swagger #Maven #Backend**
