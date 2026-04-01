package br.edu.ifsp.bra.aula3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifsp.bra.aula3.service.UserServiceImpl;

public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl = new UserServiceImpl();


    @GetMapping("/users")
    public String getUsers() {
        return userServiceImpl.toString();
    }


}
