package br.edu.ifsp.bra.aula7.controller;

import br.edu.ifsp.bra.aula7.model.Categoria;
import br.edu.ifsp.bra.aula7.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Categoria> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }
}
