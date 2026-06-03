# project-java-integration

## Projeto 5 — Testes Automatizados

Projeto voltado para testes unitários e testes de interface.

### Tecnologias utilizadas

* JUnit
* Mockito
* Spring Test
* TestFX

## Testes do Controller (Back-end)

### Recursos utilizados

* `@WebMvcTest`
* `MockMvc`
* `Mockito`
* `jsonPath`

### Objetivos

* Testar endpoints REST isoladamente
* Simular requisições HTTP
* Validar respostas JSON
* Garantir chamadas corretas aos services

### Conceitos trabalhados

* Mock de dependências
* Testes isolados
* Validação de APIs REST

## Testes do Controller (Front-end)

### Recursos utilizados

* TestFX
* JavaFX
* Mockito

### Objetivos

* Validar componentes gráficos
* Simular ações do usuário
* Testar comportamento da interface
* Validar tratamento de erros

### Conceitos trabalhados

* Testes de interface
* Simulação de eventos
* Integração entre controller e componentes JavaFX


## Testes do ApiLineService

### Recursos utilizados

* `RestTemplate`
* `ResponseEntity`
* `ParameterizedTypeReference`
* Mockito

### Objetivos

* Simular consumo de API REST
* Mockar respostas HTTP
* Validar comunicação entre front-end e API

### Conceitos trabalhados

* Mock de chamadas HTTP
* Testes de serviços
* Simulação de APIs REST
