package br.edu.ifsp.bra.aula3.service;

import br.edu.ifsp.bra.aula3.model.User;

public interface UserService {

    void add(User newUser);

    User find(String login);

    boolean remove(String login);
}