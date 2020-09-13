package br.com.vouchercall.service;

import br.com.vouchercall.model.User;
import br.com.vouchercall.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private UserRepository repository;

    public RegistrationService(UserRepository repository) {
        this.repository = repository;
    }

    public Integer register(User user) {
        repository.save(user);
        return user.getId();
    }
}
