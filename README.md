# project-java-integration

## Projeto 2 — Separação entre Front-end e Back-end

Projeto focado na separação de responsabilidades entre interface gráfica e lógica de dados.

### Tecnologias utilizadas
- Maven
- JavaFX
- Java 8

## Front-end

O front-end passa a consumir os dados do back-end através de dependência Maven.

### Estrutura

- `Main` → inicia a aplicação
- `Controller` → consome os dados do back-end e atualiza a interface

## Back-end

O back-end contém os modelos:

* `Category`
* `Model`
* `Line`

### Relacionamentos

* Uma `Line` possui várias `Category`
* Cada `Category` possui vários `Model`

### Conceitos trabalhados

* Modularização
* Separação de camadas
* Uso de dependências Maven
* Relacionamento entre entidades

### Instalação do back-end

```bash
mvn clean install
```

Esse comando instala o back-end no repositório Maven local para ser utilizado pelo front-end.
