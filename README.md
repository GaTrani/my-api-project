# Gestor Auto

## 🚀 Sobre o Projeto
Este é um projeto web que utiliza **Java**, **Spring Boot**, **JavaScript**, **HTML**, e **CSS**, seguindo o padrão de arquitetura **MVC** (Model-View-Controller). O objetivo é fornecer uma aplicação funcional, modular e fácil de manter, exemplificando as melhores práticas no desenvolvimento full-stack.

---

## 🛠️ Tecnologias Utilizadas
As tecnologias utilizadas neste projeto foram escolhidas para garantir eficiência, escalabilidade e uma boa experiência do desenvolvedor.

### Back-end:
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  
  Linguagem principal do projeto, garantindo performance e robustez.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)  
  Framework para criar a API REST e gerenciar a lógica de negócio.
  - **Spring MVC**: Organização e controle da lógica de rotas e regras de negócio.
  - **Spring Data JPA**: Gerenciamento de persistência e interação com o banco de dados.
  - **Spring Security**: Controle de autenticação e autorização.

### Front-end:
- ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)  
  Estruturação e marcação das páginas.
- ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)  
  Estilização e design responsivo.
- ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)  
  Interatividade e comunicação assíncrona com o servidor via APIs.

### Banco de Dados:
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)  
  Banco de dados relacional para armazenar informações.

### Outras ferramentas:
- ![Lombok](https://img.shields.io/badge/Lombok-2C2255?style=for-the-badge&logo=java&logoColor=white)  
  Redução de boilerplate no código Java.
- ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)  
  Template engine para renderizar páginas HTML no servidor.
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)  
  Gerenciador de dependências do projeto.
- ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)  
  Controle de versão e colaboração.
- ![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)  
  Framework CSS para facilitar a criação de designs responsivos.

---

## ⚙️ Arquitetura do Projeto

Este projeto segue o padrão **MVC (Model-View-Controller)**, que organiza o código em três principais camadas:

### 📁 Estrutura de Pacotes
```plaintext
src/main/java/com/example/demo
├── controller         # Controladores responsáveis pelas rotas e lógica de requisição
├── model              # Classes de domínio (entidades)
├── repository         # Interfaces para acesso ao banco de dados
├── service            # Regras de negócio e lógica central do sistema
└── config             # Configurações (ex.: segurança, CORS, etc.)
