package com.cov.covproxym.controller;

import com.cov.covproxym.Service.CodeService;
import com.cov.covproxym.Service.UserService;
import com.cov.covproxym.model.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {
    @Autowired
    private CodeService codeService ;
    @RequestMapping(method = RequestMethod.POST,value = "/code")
    public Code saveKey(@RequestParam Long Iduser){
        return  codeService.saveKey(Iduser) ;

    }

}
