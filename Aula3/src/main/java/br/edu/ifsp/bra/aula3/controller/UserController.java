package br.edu.ifsp.bra.aula3.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.aula3.service.UserService;
import br.edu.ifsp.bra.aula3.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String add(@RequestBody User newUser) {
        userService.add(newUser);
        return "Usuário adicionado!";
    }

    @GetMapping("/{login}")
    public User find(@PathVariable String login) {
        return userService.find(login);
    }

    @DeleteMapping("/{login}")
    public String remove(@PathVariable String login) {
        boolean removed = userService.remove(login);
        if (removed) {
            return "Usuário removido!";
        }
        return "Usuário não encontrado.";
    }
}