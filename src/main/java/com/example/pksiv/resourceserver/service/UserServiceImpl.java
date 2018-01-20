package com.example.pksiv.resourceserver.service;

import com.example.pksiv.resourceserver.persistence.UserRepository;
import com.example.pksiv.resourceserver.validation.EmailExistsException;
import com.example.pksiv.resourceserver.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public User registerNewUser(final User user) throws EmailExistsException {
        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
        }
        return repository.save(user);
    }

    private boolean emailExist(String email) {
        final User user = repository.findByEmail(email);
        return user != null;
    }
}
