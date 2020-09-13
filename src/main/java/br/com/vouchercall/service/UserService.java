package br.com.vouchercall.service;

import br.com.vouchercall.model.User;
import br.com.vouchercall.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User loadUserByUsername(String username) {
        return repository.findByUsername(username);
    }
}
