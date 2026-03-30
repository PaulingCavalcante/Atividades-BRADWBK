package br.edu.ifsp.bra.bradwbk.aula3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostagemController {

    private List<Postagem> postagens = new ArrayList<>();
    private Long proximoId = 1L;

    // GET /postagens — lista todas
    @GetMapping
    public ResponseEntity<List<Postagem>> listar() {
        return ResponseEntity.ok(postagens);
    }

    // GET /postagens/{id} — busca uma por id
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> buscarPorId(@PathVariable Long id) {
        return postagens.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /postagens — cria uma nova
    @PostMapping
    public ResponseEntity<Postagem> criar(@RequestBody Postagem postagem) {
        postagem.setId(proximoId++);
        postagem.setDataCriacao(java.time.LocalDateTime.now());
        postagens.add(postagem);
        return ResponseEntity.status(201).body(postagem);
    }

    // PUT /postagens/{id} — atualiza
    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizar(@PathVariable Long id,
                                               @RequestBody Postagem dados) {
        for (Postagem p : postagens) {
            if (p.getId().equals(id)) {
                p.setTitulo(dados.getTitulo());
                p.setConteudo(dados.getConteudo());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /postagens/{id} — remove e retorna o deletado
    @DeleteMapping("/{id}")
    public ResponseEntity<Postagem> deletar(@PathVariable Long id) {
        Postagem encontrada = null;
        for (Postagem p : postagens) {
            if (p.getId().equals(id)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            postagens.remove(encontrada);
            return ResponseEntity.ok(encontrada);
        }
        return ResponseEntity.notFound().build();
    }
}