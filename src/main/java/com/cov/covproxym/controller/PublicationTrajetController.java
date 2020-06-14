package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Service.PublicationTrajetSercice;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.PublicationTrajetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PublicationTrajetController {
    @Autowired
    PublicationTrajetRepository publicationTrajetRepository;
    @Autowired
    PublicationTrajetSercice publicationtrajetService;


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
}
