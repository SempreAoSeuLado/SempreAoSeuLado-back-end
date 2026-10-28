# Sempre Ao Seu Lado | Back-end

Back-end do **Sempre Ao Seu Lado**, uma plataforma voltada a ONGs de proteção animal que busca centralizar informações e facilitar os processos de adoção e de oferta de lares temporários.

A proposta é conectar organizações, pessoas interessadas em adotar e voluntários que possam acolher animais temporariamente, tornando mais simples encontrar um novo lar e identificar vagas de acolhimento disponíveis.

## Objetivos

- Centralizar informações sobre animais disponíveis para adoção.
- Facilitar a conexão entre ONGs e possíveis adotantes.
- Reunir informações sobre lares temporários e sua disponibilidade.
- Apoiar a organização e o acompanhamento dos processos de adoção e acolhimento.
- Dar mais visibilidade aos animais e às necessidades das ONGs.

## Funcionalidades planejadas

- Cadastro de ONGs e de seus animais.
- Consulta de animais disponíveis para adoção.
- Registro de interesse em adoção e acompanhamento das solicitações.
- Cadastro de voluntários interessados em oferecer lar temporário.
- Consulta e atualização de vagas disponíveis em lares temporários.
- Associação de animais a lares temporários, conforme a disponibilidade.

> O projeto está em fase inicial de desenvolvimento. As funcionalidades acima representam o escopo planejado e ainda não devem ser consideradas disponíveis.

## Tecnologias

As seguintes tecnologias já estão declaradas na configuração do projeto:

| Tecnologia | Finalidade |
| --- | --- |
| Java 21 | Linguagem de programação do back-end |
| Spring Boot 4.1.2 | Base para configuração e execução da aplicação |
| Spring Web MVC | Desenvolvimento da camada web e de endpoints HTTP |
| Spring Data JPA | Acesso e persistência de dados |
| Bean Validation | Validação de dados |
| H2 Database | Banco de dados em memória configurado atualmente |
| MySQL Connector/J | Driver para uma futura conexão com MySQL |
| Maven e Maven Wrapper | Gerenciamento de dependências e build |

## Estrutura do repositório

```text
SempreAoSeuLado-back-end/
├── README.md
└── sempre-ao-seu-lado/
	├── mvnw
	├── mvnw.cmd
	├── pom.xml
	└── src/
		├── main/
		│   ├── java/br/com/sempreaoseulado/
		│   └── resources/application.properties
		└── test/java/br/com/sempreaoseulado/
```

## Como executar

### Pré-requisitos

- JDK 21 instalado e disponível no `PATH`.
- Acesso à internet para baixar as dependências na primeira execução.

O repositório inclui o Maven Wrapper, portanto não é necessário instalar o Maven separadamente.

Na raiz do repositório, entre na pasta da aplicação:

```sh
cd sempre-ao-seu-lado
```

No Windows, usando PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```sh
./mvnw spring-boot:run
```

Por padrão, o servidor utiliza o endereço `http://localhost:8080`. Como os endpoints de negócio ainda serão desenvolvidos, isso não significa que exista uma página ou rota disponível em `/`.

### Executar os testes

Dentro da pasta `sempre-ao-seu-lado`, execute:

```powershell
# Windows (PowerShell)
.\mvnw.cmd test
```

```sh
# Linux ou macOS
./mvnw test
```

## Banco de dados

A configuração atual utiliza o H2 em memória, definido em `sempre-ao-seu-lado/src/main/resources/application.properties`. Os dados não são mantidos após o encerramento da aplicação.

O driver do MySQL já está incluído nas dependências, mas a conexão com um banco MySQL ainda precisa ser configurada antes de seu uso.

## Status

Em desenvolvimento: a estrutura inicial do back-end está criada, e as regras de negócio, os endpoints e os fluxos de adoção e lar temporário serão implementados nas próximas etapas.