package com.cov.covproxym.controller;

import com.cov.covproxym.Service.PublicationTrajetSercice;
import com.cov.covproxym.Service.ReservationService;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.utils.Publication;
import com.cov.covproxym.utils.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;


@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService ;
    @Autowired
    PublicationTrajetSercice publicationTrajetSercice ;

    @RequestMapping(value = "/res", method = RequestMethod.POST)
    public Map<String, Boolean> save(@RequestBody ReservationDto reservationDto) {

           reservationService.save(reservationDto);

        return Collections.singletonMap("success", true);
    }


}
