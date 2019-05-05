package com.cov.covproxym.controller;

import com.cov.covproxym.Service.LoginService;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
   public List <String>   Users()  {
      return loginService.getAllPersonNames();
    }
    @RequestMapping(value = "/auth1", method = RequestMethod.GET)
    public List <String> password(){
        return loginService.gellAllPassword();
    }


    @RequestMapping(value = "/user/login", method = RequestMethod.POST)

    public Optional<User> save(@RequestBody LoginDto loginDto) throws Exception {
      return loginService.authenticated(loginDto);



    }
}
