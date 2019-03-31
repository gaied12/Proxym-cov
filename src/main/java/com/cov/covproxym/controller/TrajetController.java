package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.Service.TrajetService;
import com.cov.covproxym.model.Trajet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrajetController {
    @Autowired
    TrajetRepository trajetRepository ;
    @Autowired
    TrajetService trajetService;
    @RequestMapping(value = "t/add",method = RequestMethod.POST)
    public Trajet save(@RequestBody Trajet trajet){
       return trajetService.savetrajet(trajet);


    }
    @RequestMapping(value = "t/add",method = RequestMethod.GET)
    public List<Trajet> trajets(){

        return trajetService.trajets();
    }
    @RequestMapping(value = "t/add/{id}",method = RequestMethod.GET)
    public Optional<Trajet>showtrajet (@PathVariable long id){
        return trajetService.showtrajet(id);
    }


}
