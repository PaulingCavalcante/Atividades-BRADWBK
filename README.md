# Atividades BRADWBK

Repositório com os exercícios práticos da disciplina **BRADWBK – Desenvolvimento Web Back-end** (IFSP), implementados em **Java + Spring Boot**.

## Estrutura

| Pasta  | Tema                                    | Stack principal                          |
| ------ | --------------------------------------- | ---------------------------------------- |
| Aula3  | API REST – CRUD de usuários            | Spring Web MVC                           |
| Aula4  | API REST – IFgram (postagens)          | Spring Web MVC                           |
| Aula5  | API GraphQL – Star Wars                 | Spring for GraphQL                       |
| Aula7  | Persistência em banco de dados          | Spring Boot (base inicial)               |

---

## Aula 3 – CRUD de Usuários (REST)

API REST simples para gerenciar usuários em memória.

- **Model:** `User` (name, login)
- **Service:** `UserService` / `UserServiceImpl` (armazenamento em `ArrayList`)
- **Controller:** `UserController` em `/users`

Endpoints:

| Verbo  | Path             | Descrição                  |
| ------ | ---------------- | -------------------------- |
| POST   | `/users`         | Adiciona um novo usuário   |
| GET    | `/users/{login}` | Busca usuário pelo login   |
| DELETE | `/users/{login}` | Remove usuário pelo login  |

---

## Aula 4 – IFgram (Modelagem + Implementação REST)

Exercício em duas partes:

1. **Modelagem dos endpoints** do recurso `posts` (tabela com verbo, path, input, output, códigos HTTP) e definição do schema JSON da postagem.
2. **Implementação** com Spring Web MVC do CRUD completo de postagens.

- **Model:** `Postagem` (id, titulo, conteudo, dataCriacao)
- **Controller:** `PostagemController` em `/posts`

Endpoints:

| Verbo  | Path          | Descrição                         | Sucesso      | Falha                |
| ------ | ------------- | --------------------------------- | ------------ | -------------------- |
| GET    | `/posts`      | Lista todas as postagens          | 200 OK       | 500                  |
| GET    | `/posts/{id}` | Busca postagem por id             | 200 OK       | 404 Not Found        |
| POST   | `/posts`      | Cria postagem (gera id e data)    | 201 Created  | 400 Bad Request      |
| PUT    | `/posts/{id}` | Atualiza título e conteúdo        | 200 OK       | 400 / 404            |
| DELETE | `/posts/{id}` | Remove e retorna a postagem       | 200 OK       | 404 Not Found        |

---

## Aula 5 – API GraphQL Star Wars

API GraphQL inspirada no schema oficial do Star Wars usando **Spring for GraphQL**.

- **Schema:** `src/main/resources/graphql/scheme.graphqls`
- **Controller:** `StarWarController`
- **Modelos:** `Character` (interface), `Human`, `Droid`, `Starship`, `Review`, `ReviewInput`, `Episode` (enum)
- **Union type:** `SearchResult = Human | Droid | Starship`

Queries:

- `hero(episode)` – retorna um herói (Luke por padrão)
- `droid(id)` – busca droid por id
- `character(id)` – busca humano ou droid por id
- `humans` / `starships` – lista todos
- `search(text)` – busca textual em humanos, droids e naves (retorna union)

Mutations:

- `createReview(episode, review)`
- `createHuman(id, nome, height)`
- `createDroid(id, nome, primaryFunction)`
- `createStarship(id, nome, length)`
- `addFriend(characterId, friendId)` – adiciona amizade entre personagens

---

## Aula 7 – Persistência com Spring (em andamento)

Projeto base do Spring Boot para a atividade de **persistência em banco de dados**. O PDF da atividade está disponível em `Aula7/Aula 7 (BRADWBK) - Persistência em banco de dados com Spring.pdf`.

Estado atual: projeto inicializado com `spring-boot-starter-webmvc`; implementação dos repositórios e entidades pendente.

---

## Como executar

Cada aula é um projeto Maven independente. Dentro da pasta da aula:

```bash
./mvnw spring-boot:run
```

Requisitos: Java 17+ (Aula 7 usa Java 21) e Maven Wrapper já incluso.
