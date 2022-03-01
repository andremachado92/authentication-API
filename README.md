# Authentication-API

API para estudos de autenticação com oatuh2 e controle de acesso com JWT.

### 📋 Pré-requisitos

JDK 11+, IDE de sua preferência.

## 🚀 Começando

Realize o clone do projeto, abra o projeto em uma IDE de sua preferência, realize
o download das dependências. Após as configrações iniciais, inicie o projeto, o Spring Boot criará as tabelas em um 
banco de dados em memória (H2) e salvará no banco o usuario: usuario@email.com senha: admin123, este será o usuário
que você se autenticará pelo swagger, caso você queira configurar outro cliente web use as credenciais abaixo para o
mesmo usuário e senha acima citado:

secret -> R0ut3V2

api.client-secret=$2a$10$xYqfk77eiSYtHPhaHUm3Y.w8YShRvLIIjR.3xaRqS5MBzni1n3N2e

api.client-id=api


## 🛠️ Construído com

Java 11, Spring Boot, Java Persistence API (JPA) para persistêcia de
dados, banco de dados H2, Swagger 2 para documentação e realização de requisições a API.

## ⚙️ Executando os END-POINTS

Acesse o link: http://localhost:8080/swagger-ui.html e obtenha o SWAGGER para ler a documentação e executar os end-points
