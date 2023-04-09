package dev.shilpa.springSecurity.controller;

import dev.shilpa.springSecurity.entity.User;
import dev.shilpa.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/newUser")
    public String addNewUser(@RequestBody User user){
        return service.addUser(user);
    }
}
