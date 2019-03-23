package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.ReservationRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.exception.NoPlaceAvailableException;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Reservation;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.Publication;
import com.cov.covproxym.utils.ReservationDto;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    ResponseService responseService;
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

        reservationRepository.save(reservation);


    }


}


///}


