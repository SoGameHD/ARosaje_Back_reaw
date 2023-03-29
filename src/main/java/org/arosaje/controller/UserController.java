package org.arosaje.controller;

import org.arosaje.entities.user.User;
import org.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping( "/getUser" )
    public User getUserByEmail(@RequestParam(name="email") String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }
}
