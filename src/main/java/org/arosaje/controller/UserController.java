package org.arosaje.controller;
import org.arosaje.entities.User;
import org.arosaje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value ="/getUsers")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getUserById")
    public Optional<User> getUserById(@RequestParam(name = "id") Integer id) {
        return userService.getUserById(id);
    }


    //@PostMapping( value = "/createUser")
    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value ="/deleteUserById")
    public void deleteUserById(@RequestParam(name = "id") Integer id) {
        userService.deleteUser(id);
    }
}







