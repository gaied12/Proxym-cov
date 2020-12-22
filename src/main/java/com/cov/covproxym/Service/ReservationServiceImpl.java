package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.ReservationRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.exception.ApplicationException;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Reservation;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    PublicationTrajetRepository publicationTrajetRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PublicationTrajetSercice publicationTrajetSercice;

    @Override
    public void save(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        User user=null;
        PublicationTrajet publicationTrajet=null;
        Optional<User> userOptional = userRepository.findById(reservationDto.getUserId());
        if (userOptional.isPresent()){
            user=userOptional.get();
            reservation.setUser( user);

        }

        Optional<PublicationTrajet> publicationTrajetOptional = publicationTrajetRepository.findById(reservationDto.getPublicationId());
        if (publicationTrajetOptional.isPresent()){
            publicationTrajet=publicationTrajetOptional.get();
            reservation.setPublicationTrajet(publicationTrajet);
        }
        if (user==null  || publicationTrajet==null) {
         //TODO create exception
        }
        Optional <User> userRes=userRepository.findById(reservationDto.getUserId());
        Optional<User>userPub= Optional.ofNullable(publicationTrajetOptional.get().getUser());
        if (userRes.equals(userPub)){
            throw new ApplicationException("this User is the  owner ", "99");


        }



        Optional<Reservation> checkExistingReservation = this.reservationRepository.findFirsByUserAndPublicationTrajet(user, publicationTrajet);
         if (checkExistingReservation.isPresent()) {
             throw new ApplicationException("dublicated reservation exception", "102");

         }

        Integer nbPlaceFromPublication =publicationTrajet.getNombreDePlace();

     //   List<Reservation> list = reservationRepository.findAllByPublicationTrajet(publicationTrajet);
       // Integer nbPlaceFromReservation = list.size();
        if (nbPlaceFromPublication == 0)
            throw new ApplicationException("no_place_available", "102");


       publicationTrajet.getReservations().add(reservation);
       publicationTrajet.setNombreDePlace(nbPlaceFromPublication-1);


       this.publicationTrajetRepository.save(publicationTrajet);
    }

    @Override
    public List<Reservation> resrvation() {
        List<Reservation> list = new ArrayList<>();
        reservationRepository.findAll().forEach(list::add);
        return list;

    }

    @Override
    public Optional<Reservation> ShowReservation(long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public ResponseEntity<String> DeleteReservation(long id) {
        reservationRepository.deleteById(id);

        return new ResponseEntity<>("Reservation Deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> DeleteAllReservation() {
        reservationRepository.findAll();
        return new ResponseEntity<>(" All Reservation Deleted", HttpStatus.OK);

    }



}





