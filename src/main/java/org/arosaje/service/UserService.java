package org.arosaje.service;

import org.springframework.beans.factory.annotation.Autowired;
import  org.arosaje.entities.User;
import org.arosaje.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional <User> getUserById(final Integer id) {
        return  userRepository.findById(id);
    }

    public  Iterable<User> getUsers(){
        return  userRepository.findAll();
    }
    public void deleteUser(final Integer id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }







    

}
