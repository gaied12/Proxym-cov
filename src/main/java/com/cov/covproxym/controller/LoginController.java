package com.cov.covproxym.controller;

import com.cov.covproxym.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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

    public Map<String, Boolean> save(@RequestParam ("username")String username, @RequestParam String password) throws Exception {
       loginService.authenticated(username,password);
        return Collections.singletonMap("Authenticated successful with"+username, true);


    }
}
