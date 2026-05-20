package br.edu.ifsp.bra.aula7.repository;

import br.edu.ifsp.bra.aula7.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
