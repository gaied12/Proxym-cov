package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.ReservationRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.exception.NoPlaceAvailableException;
import com.cov.covproxym.exception.NoUser;
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
        Optional<User> user = userRepository.findById(reservationDto.getUserId());
        if (user.isPresent()) reservation.setUser(user.get());
        Optional<PublicationTrajet> publicationTrajet = publicationTrajetRepository.findById(reservationDto.getPublicationId());
        if (publicationTrajet.isPresent()) reservation.setPublicationTrajet(publicationTrajet.get());
       Integer nbPlaceFromPublication = publicationTrajet.get().getNbr_place();

       List<Reservation> list = reservationRepository.findAllByPublicationTrajet(publicationTrajet.get());
       Integer nbPlaceFromReservation = list.size();
       if (nbPlaceFromPublication == nbPlaceFromReservation || nbPlaceFromReservation > nbPlaceFromPublication)
             throw new NoPlaceAvailableException();


    Optional<Reservation> UserFromReservation=reservationRepository.findAllByUser(user.get());
      if (UserFromReservation.isPresent())

        throw new NoUser();


        reservationRepository.save(reservation);



    }

    @Override
    public List<Reservation> resrvation() {
        List <Reservation> list=new ArrayList<>();
        reservationRepository.findAll().forEach(list::add);
        return list ;

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
        return new ResponseEntity<>(" Alll Reservation Deleted", HttpStatus.OK);

    }



}





