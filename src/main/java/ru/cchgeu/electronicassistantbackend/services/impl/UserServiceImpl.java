package ru.cchgeu.electronicassistantbackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.repositories.UserRepositories;
import ru.cchgeu.electronicassistantbackend.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    @Autowired
    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public boolean login(String login, String password) {
        if(userRepositories.findByLogin(login).getPassword().equals(password)) {

            return true;
        }
        return false;

    }
}