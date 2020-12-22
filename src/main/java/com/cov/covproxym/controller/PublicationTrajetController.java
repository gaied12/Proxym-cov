package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.Service.PublicationTrajetSercice;
import com.cov.covproxym.exception.ApplicationException;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Trajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.PublicationTrajetDto;
import com.cov.covproxym.utils.TrajetDro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)

public class PublicationTrajetController {
    @Autowired
    PublicationTrajetRepository publicationTrajetRepository;
    @Autowired
    PublicationTrajetSercice publicationtrajetService;
    @Autowired
    TrajetRepository trajetRepository ;


    @RequestMapping(value = "/pub", method = RequestMethod.POST)
    public PublicationTrajet save(@RequestBody PublicationTrajetDto publication) {
        return publicationtrajetService.save(publication);
    }


    @RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatepub(@PathVariable long id, @RequestBody PublicationTrajet publicationTrajet) {
        return publicationtrajetService.updatepub(id, publicationTrajet);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Map<String, String> deletepub(@PathVariable long id) {

        publicationtrajetService.deletepub(id);
        return Collections.singletonMap("success", "true");

    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
    public void deletall() {

        publicationtrajetService.removeall();
    }


    @RequestMapping(value = "/findAllUserForPublication/{id}", method = RequestMethod.GET)
    public List<User> findAllUserForPublication(@PathVariable Long id) {

        return publicationtrajetService.findAllUserForPublication(id);
    }

    @RequestMapping(value = "/pub/all", method = RequestMethod.GET)
    public List<PublicationTrajet> showpubs() {

        return publicationtrajetService.showpubs();
    }

    @RequestMapping(value = "/pub/{id}", method = RequestMethod.GET)
    public Optional<PublicationTrajet> showpub(@PathVariable long id) {
        Optional<PublicationTrajet> publicationTrajet = publicationtrajetService.showpub(id);
        if (publicationTrajet.isPresent())

        return     publicationtrajetService.findById(id);


        return publicationTrajet;
    }
    @RequestMapping(value = "/pub/cor", method = RequestMethod.GET)
    public String showCgeo(@RequestParam String addd) {
        return  publicationtrajetService.cordGeo(addd);



    }
    @RequestMapping(value = "/pub/info/{id}", method = RequestMethod.GET)
    public void pubInfo(@PathVariable  Long id) {
        Optional<PublicationTrajet>publicationTrajet=publicationTrajetRepository.findById(id);
        if (!publicationTrajet.isPresent()){
            throw  new ApplicationException("Pub not Existe","197");
        }
        String geoDepart=publicationtrajetService.cordGeo(publicationTrajet.get().getDepart());
        String geoDestination=publicationtrajetService.cordGeo(publicationTrajet.get().getDestination());



    }
    @RequestMapping(value = "/pub/distance", method = RequestMethod.GET)
    public TrajetDro pubInfo(@RequestParam String d, @RequestParam String ds) {
        return  publicationtrajetService.trajetDesc(d,ds);

    }
    @RequestMapping(value = "/pub/trajet", method = RequestMethod.POST)
    public Trajet addTrajet(@RequestBody TrajetDro trajet){
        Trajet trajet1=new Trajet();
        trajet1.setTotal_distance(trajet.getTotal_distance());
        trajet1.setTotal_time(trajet.getTotal_time());
        Trajet trajet2= trajetRepository.save(trajet1);
        return  trajet2 ;
    }










}
