
# JWT API

API REST desenvolvida com Spring Boot para estudo e implementação de autenticação e autorização 
utilizando JWT (JSON Web Token) e Spring Security.

## Sobre o projeto

Este projeto foi desenvolvido como um estudo prático de autenticação e autorização em uma API REST.

Durante o desenvolvimento foram implementados:
- Cadastro de usuários;
- Criptografia de senhas com BCrypt;
- Login de usuários;
- Geração de tokens JWT;
- Validação do JWT através de um filtro do Spring Security;
- Autenticação através do `SecurityContext`;
- Autorização baseada em perfil (`USER` e `ADMIN`);
- Proteção de endpoints;
- Utilização de banco de dados H2.

## Tecnologias utilizadas

- Java 17;
- Spring Boot;
- Spring Security;
- JWT;
- BCrypt;
- Spring Data JPA;
- H2 Database;
- Maven;
- Git e GitHub.

## Estrutura do projeto

```text
src/main/java/com/carlos/jwtapi/
├── config/
│   └── SecurityConfig.java
├── controller/
│   ├── AdminController.java
│   ├── AuthController.java
│   └── UsuarioController.java
├── dto/
│   └── LoginRequest.java
├── entity/
│   ├── Role.java
│   └── Usuario.java
├── repository/
│   └── UsuarioRepository.java
├── security/
│   ├── JwtAuthFilter.java
│   └── JwtService.java
└── service/
    ├── AuthService.java
    └── UsuarioService.java
```
## Como executar o projeto

Clone o repositório:

```bash
git clone https://github.com/oliveirabilu/jwt-api.git
```
Entre na pasta do projeto:

```bash
cd jwt-api
```
Execute a aplicação:

```bash
mvn spring-boot:run
```
A aplicação será iniciada em:

```text
http://localhost:8080
```
## Cadastro de usuário

Para cadastrar um usuário, envie uma requisição `POST` para:
```text
http://localhost:8080/usuarios
```
Exemplo de requisição:

```json
{
"login" : "carlos",
"senha" : "123456",
"role" : "USER"
}
```
A senha será armazenada no banco de dados utilizando criptografia BCrypt.
## Login

Para realizar o login, envie uma requisição `POST` para:
```text
http://localhost:8080/login
```
Exemplo de requisição:
```json
{
  "login" : "carlos",
  "senha" : "123456"
}
```
Em caso de sucesso, a API retorna um token JWT.

Exemplo de resposta:
```text
eyJhbGciOiJIUzI1NiJ9...
```
## Acesso a endpoints protegidos

Para acessar endpoints protegidos, envie o token JWT no header `Authorization`:
```text
Authorization: Bearer SEU_TOKEN_JWT
```
## Perfis de acesso

A API possui dois perfis de usuário:
- `USER`: usuário comum;
- `ADMIN`: usuário administrador.

Endpoints administrativos exigem o perfil `ADMIN`.

Exemplo de endpoint protegido:
```text
GET http://localhost:8080/admin/teste
```
## Como funciona a autenticação JWT

O processo de autenticação ocorre da seguinte forma:
1. O usuário realiza o cadastro.
2. A senha é armazenada utilizando BCrypt.
3. O usuário realiza o login informando `login` e `senha`.
4. A API verifica as credenciais.
5. Se as credenciais forem válidas, um token JWT é gerado.
6. O cliente envia o token nas próximas requisições protegidas.
7. O `JwtAuthFilter` valida o token e identifica o usuário e seu perfil.
8. O Spring Security verifica se o usuário possui permissão para acessar o endpoint.

## Banco de dados H2

O projeto utiliza o banco de dados H2 em memória para armazenamento dos usuários.
O console do H2 pode ser acessado em:
```text
http://localhost:8080/h2-console
```
Dados de conexão:
```text
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha:
```