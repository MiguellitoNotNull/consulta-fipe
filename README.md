# Consulta FIPE

Aplicação desenvolvida em Java para consultar valores de veículos com base na Tabela FIPE, utilizando uma API externa para obter informações atualizadas sobre marcas, modelos, anos e preços.

O projeto foi desenvolvido com foco na prática de consumo de APIs, manipulação de dados JSON e aplicação dos conceitos de programação Java.

## Funcionalidades

- Consulta de veículos por categoria: carros, motos e caminhões.
- Listagem das marcas disponíveis na API.
- Consulta de modelos a partir do código da marca.
- Filtro de modelos pelo nome informado pelo usuário.
- Consulta dos anos disponíveis para o modelo selecionado.
- Busca automática dos valores FIPE para todos os anos disponíveis.
- Exibição de informações como marca, modelo, ano, combustível, código FIPE e valor.

## Tecnologias utilizadas

- **Java 21** — Linguagem de programação.
- **Spring Boot** — Inicialização e execução da aplicação.
- **Maven** — Gerenciamento de dependências.
- **Jackson** — Conversão de dados JSON em objetos Java.
- **Streams e Collections** — Filtragem e manipulação de listas.
- **API FIPE** — Fonte dos dados consultados.

## API utilizada

O projeto utiliza a API Parallelum FIPE:

https://parallelum.com.br/fipe/api/v1/

## Como executar o projeto

1. Clone este repositório:

```bash
git clone https://github.com/MiguellitoNotNull/consulta-fipe.git
```

2. Entre na pasta do projeto:

```bash
cd consulta-fipe
```

3. Execute a aplicação utilizando o Maven Wrapper:

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

4. Siga as instruções apresentadas no terminal para realizar as consultas.

## Objetivo do projeto

Este projeto foi desenvolvido como parte dos meus estudos em Backend Java, com o objetivo de aplicar conhecimentos de orientação a objetos, consumo de APIs, conversão de JSON, Collections, Streams e organização de aplicações Java.

