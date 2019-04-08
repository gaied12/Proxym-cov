package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.Service.UserService;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserService userService ;
@RequestMapping(value = "/add/user",method = RequestMethod.POST)
    public User save( @RequestBody User user) {
        return userService.saveUser(user);
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> showpub(@PathVariable long id) {
        return userService.findById(id);
    }
}




