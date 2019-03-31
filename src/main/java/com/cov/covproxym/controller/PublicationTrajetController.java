package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.Service.PublicationTrajetSercice;
import com.cov.covproxym.Service.TrajetService;
import com.cov.covproxym.exception.NotFoundException;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PublicationTrajetController {
    @Autowired
    PublicationTrajetRepository publicationTrajetRepository;
    @Autowired
    PublicationTrajetSercice publicationtrajetService;
    @Autowired
    TrajetRepository trajetRepository;
    @Autowired
    TrajetService trajetService;

    @RequestMapping(value = "/pub", method = RequestMethod.POST)
    public Map<String, Boolean> save(@RequestBody Publication publication) {
        publicationtrajetService.save(publication);
        return Collections.singletonMap("success", true);
    }


    @RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatepub(@PathVariable long id, @RequestBody PublicationTrajet publicationTrajet) {
        return publicationtrajetService.updatepub(id, publicationTrajet);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletepub(@PathVariable long id) {

        return publicationtrajetService.deletepub(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletall() {

        return publicationtrajetService.deleteall();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PublicationTrajet> showpubs() {
        return publicationtrajetService.showpubs();
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public Optional<PublicationTrajet> showpub(@PathVariable long id) {
        return publicationtrajetService.showpub(id);
    }
}
