package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.ReservationRepository;
import com.cov.covproxym.Service.PublicationTrajetSercice;
import com.cov.covproxym.Service.ReservationService;
import com.cov.covproxym.model.Reservation;
import com.cov.covproxym.utils.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    PublicationTrajetSercice publicationTrajetSercice;
    @Autowired
    ReservationRepository reservationRepository;


    @RequestMapping(value = "/add/res", method = RequestMethod.POST)
    public Map <String,Boolean> save(@RequestBody ReservationDto reservationDto) {

         reservationService.save(reservationDto);
        return Collections.singletonMap("success", true);


    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Optional<Reservation> show(@PathVariable long id) {

        return reservationService.ShowReservation(id);
    }

    @RequestMapping(value = "/res/all", method = RequestMethod.GET)
    public List<Reservation> showAlll() {


        return reservationService.resrvation();
    }




}
