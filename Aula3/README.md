# IFgram API – Exercícios de Modelagem e Implementação
 
## Exercício 1 – Modelagem de Endpoints
 
Baseado na especificação do início do documento para o **IFgram**, modele os *endpoints*, preenchendo a tabela com a modelagem da sua API, bem como a especificação do esquema (*Schema*) em JSON.
 
> 💡 Para validar o seu JSON, use algum site de validação, tal como:
> - [https://jsonformatter.curiousconcept.com/](https://jsonformatter.curiousconcept.com/)
> - [https://jsonlint.com/](https://jsonlint.com/)
 
---
 
### Template
 
#### Especificação do esquema em JSON
 
```json
{
  "id": 1,
  "titulo": "Minha primeira postagem teste",
  "conteudo": "Conteúdo da postagem: teste.",
  "dataCriacao": "2025-03-28T10:00:00"
}
```
 
---
 
#### Definição dos endpoints para o recurso
 
| Verbo HTTP | Endpoints (path) |  Descrição                                 |  Input                                                                    |  Outputs                                                                                                                                                                                                                                                                                           |  Cód  Sucesso |  Cód. Falha                        |
| ---------- | ---------------- | ------------------------------------------ | ------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------- | ---------------------------------- |
| GET        | /posts           | Listagem dos posts                         |                                                                           | [<br>   {<br>  "id": 1,<br>  "titulo": "Minha primeira postagem teste",<br>  "conteudo": "Conteúdo da postagem: teste.",<br>  "dataCriacao": "2025-03-28T10:00:00"<br>   },<br>   {<br>      "id":2,<br>      "titulo":"...",<br>      "conteudo":"...",<br>      "dataCriacao":"..."<br>   }<br>] | 200 OK        | 500<br>Internal<br>Server<br>Error |
| GET        | /posts/{id}      | Lista o post com ID referenciado           |                                                                           |  {<br>  "id": 1,<br>  "titulo": "Minha primeira postagem teste",<br>  "conteudo": "Conteúdo da postagem: teste.",<br>  "dataCriacao": "2025-03-28T10:00:00"<br>   }                                                                                                                                | 200 OK        | 404 Not Found                      |
| POST       | /posts           | Incluir post novo                          | {<br>"titulo": "Titulo post",<br>"conteudo": "novo post"<br>}             |                                                                                                                                                                                                                                                                                                    | 201 Created   | 400 Bad Request                    |
| PUT        | /posts/{id}      | Atualiza o post o post com ID referenciado | {<br>"titulo": "Titulo novo",<br>"conteudo": "Alteração de conteúdo"<br>} |                                                                                                                                                                                                                                                                                                    | 200 OK        | 400 Bad Request / 404 Not Found    |
| DELETE     | /posts/{id}      | Deleta o post com ID referenciado          |                                                                           |  {<br>  "id": 1,<br>  "titulo": "Postagem deletada",<br>  "conteudo": "Conteúdo da postagem deletada"<br>   }                                                                                                                                                                                      | 200 OK        | 404 Not Found                      |
 
---
 
## Exercício 2 – Implementação com Spring Web MVC
 
Implemente o que foi especificado no **Exercício 1** em um projeto Java com **Spring Web MVC**, seguindo o que foi apresentado em sala de aula.
 
### Requisitos
 
- Java 17+
- Spring Boot com dependência `spring-boot-starter-web`
- Maven ou Gradle como gerenciador de dependências
