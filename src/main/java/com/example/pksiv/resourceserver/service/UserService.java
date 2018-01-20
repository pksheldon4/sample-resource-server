package com.example.pksiv.resourceserver.service;

import com.example.pksiv.resourceserver.validation.EmailExistsException;
import com.example.pksiv.resourceserver.web.model.User;

public interface UserService {
    User registerNewUser(User user) throws EmailExistsException;
}
