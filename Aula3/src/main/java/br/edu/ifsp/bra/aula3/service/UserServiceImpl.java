package br.edu.ifsp.bra.aula3.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.ifsp.bra.aula3.model.User;

@Configuration
public class UserServiceImpl implements UserService {

    ArrayList<User> users = new ArrayList<>();

    @Bean    
    @Override
    public void add(User newUser) {
        // TODO Auto-generated method stub

    }
    @Bean    
    @Override
    public User find(String login) {
        // TODO Auto-generated method stub
        return null;
    }
    @Bean    
    @Override
    public boolean remove(String login) {
        // TODO Auto-generated method stub
        return false;
    }

}
