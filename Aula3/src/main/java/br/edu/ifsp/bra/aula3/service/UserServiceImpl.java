package br.edu.ifsp.bra.aula3.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.edu.ifsp.bra.aula3.model.User;

@Service  //Bean
public class UserServiceImpl implements UserService {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void add(User newUser) {
        users.add(newUser);
    }

    @Override
    public User find(String login) {
        for (User u : users) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean remove(String login) {
        return users.removeIf(u -> u.getLogin().equals(login));
    }
}
