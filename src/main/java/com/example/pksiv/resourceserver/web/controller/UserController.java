package com.example.pksiv.resourceserver.web.controller;

import com.example.pksiv.resourceserver.persistence.UserRepository;
import com.example.pksiv.resourceserver.service.UserService;
import com.example.pksiv.resourceserver.validation.EmailExistsException;
import com.example.pksiv.resourceserver.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    //

    @RequestMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping("{id}")
    public User view(@PathVariable("id") User user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid final User user) throws EmailExistsException {
        return userService.registerNewUser(user);
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") final Long id) {
        userRepository.delete(id);
    }

}
