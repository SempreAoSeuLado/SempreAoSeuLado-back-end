# Sempre Ao Seu Lado | Back-end

Back-end do **Sempre Ao Seu Lado**, uma plataforma voltada a ONGs de proteção animal que busca centralizar informações e facilitar os processos de adoção e de oferta de lares temporários.

A proposta é conectar organizações, pessoas interessadas em adotar e voluntários que possam acolher animais temporariamente, tornando mais simples encontrar um novo lar e identificar vagas de acolhimento disponíveis.

## Objetivos

- Centralizar informações sobre animais disponíveis para adoção.
- Facilitar a conexão entre ONGs e possíveis adotantes.
- Reunir informações sobre lares temporários e sua disponibilidade.
- Apoiar a organização e o acompanhamento dos processos de adoção e acolhimento.
- Dar mais visibilidade aos animais e às necessidades das ONGs.

## Funcionalidades implementadas

- Cadastro, listagem, atualização e exclusão de animais.
- Cadastro e listagem de colaboradores.
- Atualização de colaboradores.
- Listagem de colaboradores ativos.
- Desativação de colaboradores sem exclusão do registro.
- Validação de campos obrigatórios e endereços de e-mail.
- Normalização de e-mails para letras minúsculas.
- Tratamento global de erros da API.

## Funcionalidades planejadas

- Cadastro e gerenciamento de ONGs.
- Registro de interesse em adoção e acompanhamento das solicitações.
- Cadastro de lares temporários e controle de vagas disponíveis.
- Associação de animais a lares temporários.

## API

A aplicação expõe os seguintes endpoints, sem autenticação configurada atualmente:

### Animais

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/animais` | Lista todos os animais |
| `POST` | `/animais` | Cadastra um animal |
| `PUT` | `/animais/{id}` | Atualiza um animal |
| `DELETE` | `/animais/{id}` | Exclui um animal |

Campos obrigatórios de um animal: `nome`, `especie` e `situacao`.

Exemplo de cadastro:

```json
{
	"nome": "Luna",
	"especie": "Cachorro",
	"situacao": "Disponível para adoção"
}
```

### Colaboradores

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/colaboradores` | Lista todos os colaboradores |
| `GET` | `/colaboradores/ativos` | Lista apenas colaboradores ativos |
| `POST` | `/colaboradores` | Cadastra um colaborador |
| `PUT` | `/colaboradores/{id}` | Atualiza um colaborador |
| `PATCH` | `/colaboradores/{id}/desativar` | Desativa um colaborador |

Campos obrigatórios de um colaborador: `nome`, `email` e `perfil`. O e-mail deve ser válido e não pode estar cadastrado anteriormente.

Exemplo de cadastro:

```json
{
	"nome": "Maria Silva",
	"email": "maria@example.com",
	"perfil": "Voluntária"
}
```

### Respostas de erro

- `400 Bad Request`: dados enviados não passaram pela validação.
- `404 Not Found`: animal ou colaborador não encontrado.
- `409 Conflict`: e-mail de colaborador já cadastrado.

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
		│   │   ├── SempreAoSeuLadoApplication.java
		│   │   ├── controller/
		│   │   │   ├── AnimalController.java
		│   │   │   └── ColaboradorController.java
		│   │   ├── entity/
		│   │   │   ├── Animal.java
		│   │   │   └── Colaborador.java
		│   │   ├── exception/
		│   │   │   ├── AnimalNaoEncontradoException.java
		│   │   │   ├── ColaboradorNaoEncontradoException.java
		│   │   │   ├── EmailDuplicadoException.java
		│   │   │   └── GlobalExceptionHandler.java
		│   │   ├── repository/
		│   │   │   ├── AnimalRepository.java
		│   │   │   └── ColaboradorRepository.java
		│   │   └── service/
		│   │       ├── AnimalService.java
		│   │       └── ColaboradorService.java
		│   └── resources/application.properties
		└── test/java/br/com/sempreaoseulado/
			└── SempreAoSeuLadoApplicationTests.java
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

Por padrão, o servidor utiliza o endereço `http://localhost:8080`. A API pode ser acessada, por exemplo, em `http://localhost:8080/animais`.

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

Em desenvolvimento: os módulos de animais e colaboradores já possuem operações básicas de persistência e validação. Os fluxos de adoção, ONGs e lares temporários serão implementados nas próximas etapas.