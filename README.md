# project-java-integration

## Projeto 3 — Banco de Dados e Geração de Instalador

Projeto dividido em:

- Persistência com banco de dados
- Empacotamento e geração de instalador

### Tecnologias utilizadas

* PostgreSQL
* Hibernate
* Maven
* Inno Setup
* JavaFX Maven Plugin

## Banco de Dados

A conexão é configurada no `hibernate.cfg.xml`.

### Funcionalidades

* Configuração do PostgreSQL
* Mapeamento Hibernate
* Persistência das entidades:

  * `Line`
  * `Model`
  * `Category`

## Instalador

O projeto gera um executável `.exe` utilizando Maven + jpackage e posteriormente empacota tudo utilizando Inno Setup.

### Fluxo de geração

1. Maven gera o `.jar` e o executável
2. Arquivos são enviados para a pasta usada pelo Inno Setup
3. O Inno Setup gera o instalador final
4. O instalador copia os arquivos para:

   - `AppData\Local\project-java-integration`

### Conceitos trabalhados
- Persistência com Hibernate
- Integração com PostgreSQL
- Empacotamento desktop
- Geração de executáveis
- Distribuição de aplicações Java
