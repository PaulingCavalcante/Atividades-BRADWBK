package br.edu.ifsp.bra.aula7.controller;

import br.edu.ifsp.bra.aula7.model.Livro;
import br.edu.ifsp.bra.aula7.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Livro> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return repository.save(livro);
    }
}
