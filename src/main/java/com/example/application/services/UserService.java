package com.example.application.services;

import com.example.application.data.Contract;
import com.example.application.data.Role;
import com.example.application.data.User;
import com.example.application.data.UserRepository;
import com.vaadin.flow.component.page.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> get(UUID id) {
        return repository.findById(id);
    }

    public User update(User entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
/*
    public Page<User> list(Pageable pageable) {
        return (Page<User>) repository.findAll();
    }

    public Page<User> list(Pageable pageable, Specification<User> filter) {
        return repository.findAll(filter, pageable);
    }
*/
    public int count() {
        return (int) repository.count();
    }
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public User createUser(String name, Role role, Contract contract, String hashedPassword) {
        User newUser = new User(name, role, contract, hashedPassword);
        users.add(newUser);
        return newUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}