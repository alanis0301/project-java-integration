# project-java-integration

## Projeto 4 — API REST e Integração Contínua (CI)

Projeto focado em APIs REST com Spring Boot e automação de builds utilizando GitLab CI e TeamCity.

### Tecnologias utilizadas
- Spring Boot
- Swagger
- GitLab CI
- TeamCity
- Maven

## API REST

### Estrutura

- `repositories` → acesso aos dados
- `services` → regras de negócio e criação de DTOs
- `controllers` → endpoints da API
- `DTOs` → objetos de transporte de dados

### Conceitos trabalhados

- Arquitetura em camadas
- APIs REST
- Swagger
- DTOs
- Spring Boot

## GitLab CI

### Runner

O Runner é responsável por executar automaticamente os builds após commits e pushes.

### Maven Cache

Foi utilizada a pasta:

```text
C:\maven_cache
```
para:

- armazenar dependências
- acelerar builds
- compartilhar dependências entre projetos

### Fluxo da CI

1. Clona o back-end
2. Executa build do front-end
3. Executa `mvn clean install` no back-end
4. Executa a API via:

```bash
java -jar project-java-back-end-2-1.0-SNAPSHOT.jar
```

### Conceitos trabalhados

- Integração contínua
- Automação de build
- Maven cache
- Execução automatizada de aplicações

## TeamCity

### Configurações principais

- Configuração de múltiplos repositórios
- Uso de cache Maven customizado
- Build automático do front-end e back-end
- Execução automática da API

### Build Steps

- `clean package` do front-end
- `clean install` do back-end
- execução do `.jar` da API

### Conceitos trabalhados

- Pipelines CI
- Integração entre projetos
- Cache de dependências
- Build automatizado
